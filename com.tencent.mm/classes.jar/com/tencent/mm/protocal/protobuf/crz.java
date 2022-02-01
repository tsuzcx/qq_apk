package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class crz
  extends cvw
{
  public int HgA;
  public String gvo;
  public String gvp;
  public String gvq;
  public String gvr;
  public String gvs;
  public String yxn;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152666);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.gvo != null) {
        paramVarArgs.d(2, this.gvo);
      }
      if (this.gvp != null) {
        paramVarArgs.d(3, this.gvp);
      }
      if (this.gvq != null) {
        paramVarArgs.d(4, this.gvq);
      }
      if (this.gvr != null) {
        paramVarArgs.d(5, this.gvr);
      }
      if (this.gvs != null) {
        paramVarArgs.d(6, this.gvs);
      }
      paramVarArgs.aS(7, this.HgA);
      if (this.yxn != null) {
        paramVarArgs.d(8, this.yxn);
      }
      AppMethodBeat.o(152666);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label722;
      }
    }
    label722:
    for (int i = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.gvo != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.gvo);
      }
      i = paramInt;
      if (this.gvp != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.gvp);
      }
      paramInt = i;
      if (this.gvq != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.gvq);
      }
      i = paramInt;
      if (this.gvr != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.gvr);
      }
      paramInt = i;
      if (this.gvs != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.gvs);
      }
      i = paramInt + f.a.a.b.b.a.bz(7, this.HgA);
      paramInt = i;
      if (this.yxn != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.yxn);
      }
      AppMethodBeat.o(152666);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(152666);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        crz localcrz = (crz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152666);
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
            localcrz.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152666);
          return 0;
        case 2: 
          localcrz.gvo = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(152666);
          return 0;
        case 3: 
          localcrz.gvp = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(152666);
          return 0;
        case 4: 
          localcrz.gvq = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(152666);
          return 0;
        case 5: 
          localcrz.gvr = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(152666);
          return 0;
        case 6: 
          localcrz.gvs = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(152666);
          return 0;
        case 7: 
          localcrz.HgA = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(152666);
          return 0;
        }
        localcrz.yxn = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(152666);
        return 0;
      }
      AppMethodBeat.o(152666);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.crz
 * JD-Core Version:    0.7.0.1
 */