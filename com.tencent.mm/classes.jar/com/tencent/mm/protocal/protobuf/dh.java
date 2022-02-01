package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dh
  extends com.tencent.mm.bx.a
{
  public String CxW;
  public String CxX;
  public String CxY;
  public ahe CxZ;
  public int Cya;
  public int channel;
  public String iaw;
  public int scene;
  public String vBp;
  public int vzO;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91349);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.CxW == null)
      {
        paramVarArgs = new b("Not all required fields were included: f2f_id");
        AppMethodBeat.o(91349);
        throw paramVarArgs;
      }
      if (this.CxY == null)
      {
        paramVarArgs = new b("Not all required fields were included: payok_checksign");
        AppMethodBeat.o(91349);
        throw paramVarArgs;
      }
      if (this.CxW != null) {
        paramVarArgs.d(1, this.CxW);
      }
      if (this.CxX != null) {
        paramVarArgs.d(2, this.CxX);
      }
      paramVarArgs.aR(3, this.channel);
      paramVarArgs.aR(4, this.vzO);
      paramVarArgs.aR(5, this.scene);
      if (this.CxY != null) {
        paramVarArgs.d(6, this.CxY);
      }
      if (this.CxZ != null)
      {
        paramVarArgs.kX(7, this.CxZ.computeSize());
        this.CxZ.writeFields(paramVarArgs);
      }
      if (this.iaw != null) {
        paramVarArgs.d(8, this.iaw);
      }
      if (this.vBp != null) {
        paramVarArgs.d(9, this.vBp);
      }
      paramVarArgs.aR(10, this.Cya);
      AppMethodBeat.o(91349);
      return 0;
    }
    if (paramInt == 1) {
      if (this.CxW == null) {
        break label890;
      }
    }
    label890:
    for (paramInt = f.a.a.b.b.a.e(1, this.CxW) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.CxX != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.CxX);
      }
      i = i + f.a.a.b.b.a.bA(3, this.channel) + f.a.a.b.b.a.bA(4, this.vzO) + f.a.a.b.b.a.bA(5, this.scene);
      paramInt = i;
      if (this.CxY != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.CxY);
      }
      i = paramInt;
      if (this.CxZ != null) {
        i = paramInt + f.a.a.a.kW(7, this.CxZ.computeSize());
      }
      paramInt = i;
      if (this.iaw != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.iaw);
      }
      i = paramInt;
      if (this.vBp != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.vBp);
      }
      paramInt = f.a.a.b.b.a.bA(10, this.Cya);
      AppMethodBeat.o(91349);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.CxW == null)
        {
          paramVarArgs = new b("Not all required fields were included: f2f_id");
          AppMethodBeat.o(91349);
          throw paramVarArgs;
        }
        if (this.CxY == null)
        {
          paramVarArgs = new b("Not all required fields were included: payok_checksign");
          AppMethodBeat.o(91349);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91349);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dh localdh = (dh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91349);
          return -1;
        case 1: 
          localdh.CxW = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91349);
          return 0;
        case 2: 
          localdh.CxX = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91349);
          return 0;
        case 3: 
          localdh.channel = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(91349);
          return 0;
        case 4: 
          localdh.vzO = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(91349);
          return 0;
        case 5: 
          localdh.scene = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(91349);
          return 0;
        case 6: 
          localdh.CxY = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91349);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ahe();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((ahe)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdh.CxZ = ((ahe)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91349);
          return 0;
        case 8: 
          localdh.iaw = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91349);
          return 0;
        case 9: 
          localdh.vBp = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91349);
          return 0;
        }
        localdh.Cya = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(91349);
        return 0;
      }
      AppMethodBeat.o(91349);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dh
 * JD-Core Version:    0.7.0.1
 */