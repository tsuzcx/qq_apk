package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class acd
  extends cvw
{
  public String GoS;
  public String GoW;
  public String Gua;
  public long Gub;
  public int mwj;
  public String vvw;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72466);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.Gua != null) {
        paramVarArgs.d(2, this.Gua);
      }
      paramVarArgs.aZ(3, this.Gub);
      if (this.GoS != null) {
        paramVarArgs.d(4, this.GoS);
      }
      if (this.GoW != null) {
        paramVarArgs.d(5, this.GoW);
      }
      paramVarArgs.aS(6, this.mwj);
      if (this.vvw != null) {
        paramVarArgs.d(7, this.vvw);
      }
      AppMethodBeat.o(72466);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label642;
      }
    }
    label642:
    for (paramInt = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Gua != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.Gua);
      }
      i += f.a.a.b.b.a.p(3, this.Gub);
      paramInt = i;
      if (this.GoS != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.GoS);
      }
      i = paramInt;
      if (this.GoW != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.GoW);
      }
      i += f.a.a.b.b.a.bz(6, this.mwj);
      paramInt = i;
      if (this.vvw != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.vvw);
      }
      AppMethodBeat.o(72466);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(72466);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        acd localacd = (acd)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72466);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((jc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localacd.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72466);
          return 0;
        case 2: 
          localacd.Gua = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(72466);
          return 0;
        case 3: 
          localacd.Gub = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(72466);
          return 0;
        case 4: 
          localacd.GoS = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(72466);
          return 0;
        case 5: 
          localacd.GoW = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(72466);
          return 0;
        case 6: 
          localacd.mwj = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(72466);
          return 0;
        }
        localacd.vvw = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(72466);
        return 0;
      }
      AppMethodBeat.o(72466);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.acd
 * JD-Core Version:    0.7.0.1
 */