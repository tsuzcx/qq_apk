package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bxx
  extends dyl
{
  public int CPw;
  public String MD5;
  public int Thm;
  public LinkedList<cxr> Thn;
  public int Tho;
  public LinkedList<cth> Thp;
  public int jUk;
  
  public bxx()
  {
    AppMethodBeat.i(155408);
    this.Thn = new LinkedList();
    this.Thp = new LinkedList();
    AppMethodBeat.o(155408);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(155409);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.jUk);
      if (this.MD5 != null) {
        paramVarArgs.f(3, this.MD5);
      }
      paramVarArgs.aY(4, this.Thm);
      paramVarArgs.e(5, 8, this.Thn);
      paramVarArgs.aY(6, this.Tho);
      paramVarArgs.e(7, 8, this.Thp);
      paramVarArgs.aY(8, this.CPw);
      AppMethodBeat.o(155409);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label776;
      }
    }
    label776:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.jUk);
      paramInt = i;
      if (this.MD5 != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.MD5);
      }
      i = g.a.a.b.b.a.bM(4, this.Thm);
      int j = g.a.a.a.c(5, 8, this.Thn);
      int k = g.a.a.b.b.a.bM(6, this.Tho);
      int m = g.a.a.a.c(7, 8, this.Thp);
      int n = g.a.a.b.b.a.bM(8, this.CPw);
      AppMethodBeat.o(155409);
      return paramInt + i + j + k + m + n;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Thn.clear();
        this.Thp.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(155409);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bxx localbxx = (bxx)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(155409);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new jg();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((jg)localObject2).parseFrom((byte[])localObject1);
            }
            localbxx.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(155409);
          return 0;
        case 2: 
          localbxx.jUk = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(155409);
          return 0;
        case 3: 
          localbxx.MD5 = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(155409);
          return 0;
        case 4: 
          localbxx.Thm = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(155409);
          return 0;
        case 5: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new cxr();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((cxr)localObject2).parseFrom((byte[])localObject1);
            }
            localbxx.Thn.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(155409);
          return 0;
        case 6: 
          localbxx.Tho = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(155409);
          return 0;
        case 7: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new cth();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((cth)localObject2).parseFrom((byte[])localObject1);
            }
            localbxx.Thp.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(155409);
          return 0;
        }
        localbxx.CPw = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(155409);
        return 0;
      }
      AppMethodBeat.o(155409);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bxx
 * JD-Core Version:    0.7.0.1
 */