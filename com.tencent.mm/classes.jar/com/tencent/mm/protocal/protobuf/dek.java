package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dek
  extends ckq
{
  public String EvA;
  public String EvK;
  public int EvP;
  public String EvQ;
  public String Evw;
  public String Evx;
  public String Evy;
  public String desc;
  public int tav;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72607);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.Evw != null) {
        paramVarArgs.d(2, this.Evw);
      }
      if (this.Evx != null) {
        paramVarArgs.d(3, this.Evx);
      }
      if (this.Evy != null) {
        paramVarArgs.d(4, this.Evy);
      }
      paramVarArgs.aR(5, this.tav);
      if (this.desc != null) {
        paramVarArgs.d(6, this.desc);
      }
      paramVarArgs.aR(7, this.EvP);
      if (this.EvA != null) {
        paramVarArgs.d(8, this.EvA);
      }
      if (this.EvK != null) {
        paramVarArgs.d(9, this.EvK);
      }
      if (this.EvQ != null) {
        paramVarArgs.d(10, this.EvQ);
      }
      AppMethodBeat.o(72607);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label830;
      }
    }
    label830:
    for (int i = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Evw != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Evw);
      }
      i = paramInt;
      if (this.Evx != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Evx);
      }
      paramInt = i;
      if (this.Evy != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Evy);
      }
      i = paramInt + f.a.a.b.b.a.bA(5, this.tav);
      paramInt = i;
      if (this.desc != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.desc);
      }
      i = paramInt + f.a.a.b.b.a.bA(7, this.EvP);
      paramInt = i;
      if (this.EvA != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.EvA);
      }
      i = paramInt;
      if (this.EvK != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.EvK);
      }
      paramInt = i;
      if (this.EvQ != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.EvQ);
      }
      AppMethodBeat.o(72607);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(72607);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dek localdek = (dek)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72607);
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
            localdek.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72607);
          return 0;
        case 2: 
          localdek.Evw = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(72607);
          return 0;
        case 3: 
          localdek.Evx = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(72607);
          return 0;
        case 4: 
          localdek.Evy = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(72607);
          return 0;
        case 5: 
          localdek.tav = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(72607);
          return 0;
        case 6: 
          localdek.desc = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(72607);
          return 0;
        case 7: 
          localdek.EvP = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(72607);
          return 0;
        case 8: 
          localdek.EvA = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(72607);
          return 0;
        case 9: 
          localdek.EvK = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(72607);
          return 0;
        }
        localdek.EvQ = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(72607);
        return 0;
      }
      AppMethodBeat.o(72607);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dek
 * JD-Core Version:    0.7.0.1
 */