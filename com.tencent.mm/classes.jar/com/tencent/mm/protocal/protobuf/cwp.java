package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cwp
  extends ckq
{
  public String DSX;
  public int Eop;
  public int Eoq;
  public String Eos;
  public String dnk;
  public String signature;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91698);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.DSX != null) {
        paramVarArgs.d(2, this.DSX);
      }
      if (this.signature != null) {
        paramVarArgs.d(3, this.signature);
      }
      if (this.Eos != null) {
        paramVarArgs.d(4, this.Eos);
      }
      if (this.dnk != null) {
        paramVarArgs.d(5, this.dnk);
      }
      paramVarArgs.aR(6, this.Eop);
      paramVarArgs.aR(7, this.Eoq);
      AppMethodBeat.o(91698);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label646;
      }
    }
    label646:
    for (int i = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.DSX != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.DSX);
      }
      i = paramInt;
      if (this.signature != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.signature);
      }
      paramInt = i;
      if (this.Eos != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Eos);
      }
      i = paramInt;
      if (this.dnk != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.dnk);
      }
      paramInt = f.a.a.b.b.a.bA(6, this.Eop);
      int j = f.a.a.b.b.a.bA(7, this.Eoq);
      AppMethodBeat.o(91698);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(91698);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cwp localcwp = (cwp)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91698);
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
            localcwp.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91698);
          return 0;
        case 2: 
          localcwp.DSX = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91698);
          return 0;
        case 3: 
          localcwp.signature = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91698);
          return 0;
        case 4: 
          localcwp.Eos = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91698);
          return 0;
        case 5: 
          localcwp.dnk = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91698);
          return 0;
        case 6: 
          localcwp.Eop = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(91698);
          return 0;
        }
        localcwp.Eoq = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(91698);
        return 0;
      }
      AppMethodBeat.o(91698);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cwp
 * JD-Core Version:    0.7.0.1
 */