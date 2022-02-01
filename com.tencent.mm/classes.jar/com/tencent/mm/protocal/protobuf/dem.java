package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dem
  extends ckq
{
  public String CsB;
  public String CxX;
  public String EvO;
  public String EvW;
  public String Evw;
  public String Evx;
  public int tav;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72609);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.CsB != null) {
        paramVarArgs.d(2, this.CsB);
      }
      if (this.CxX != null) {
        paramVarArgs.d(3, this.CxX);
      }
      if (this.Evw != null) {
        paramVarArgs.d(4, this.Evw);
      }
      if (this.Evx != null) {
        paramVarArgs.d(5, this.Evx);
      }
      paramVarArgs.aR(6, this.tav);
      if (this.EvO != null) {
        paramVarArgs.d(7, this.EvO);
      }
      if (this.EvW != null) {
        paramVarArgs.d(8, this.EvW);
      }
      AppMethodBeat.o(72609);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label722;
      }
    }
    label722:
    for (int i = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.CsB != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.CsB);
      }
      i = paramInt;
      if (this.CxX != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.CxX);
      }
      paramInt = i;
      if (this.Evw != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Evw);
      }
      i = paramInt;
      if (this.Evx != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.Evx);
      }
      i += f.a.a.b.b.a.bA(6, this.tav);
      paramInt = i;
      if (this.EvO != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.EvO);
      }
      i = paramInt;
      if (this.EvW != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.EvW);
      }
      AppMethodBeat.o(72609);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(72609);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dem localdem = (dem)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72609);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ip();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((ip)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdem.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72609);
          return 0;
        case 2: 
          localdem.CsB = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(72609);
          return 0;
        case 3: 
          localdem.CxX = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(72609);
          return 0;
        case 4: 
          localdem.Evw = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(72609);
          return 0;
        case 5: 
          localdem.Evx = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(72609);
          return 0;
        case 6: 
          localdem.tav = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(72609);
          return 0;
        case 7: 
          localdem.EvO = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(72609);
          return 0;
        }
        localdem.EvW = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(72609);
        return 0;
      }
      AppMethodBeat.o(72609);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dem
 * JD-Core Version:    0.7.0.1
 */