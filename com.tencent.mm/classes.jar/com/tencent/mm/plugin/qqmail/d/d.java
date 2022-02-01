package com.tencent.mm.plugin.qqmail.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cvw;
import com.tencent.mm.protocal.protobuf.jc;
import java.util.LinkedList;

public final class d
  extends cvw
{
  public int xrc;
  public String xrd;
  public String xre;
  public String xrf;
  public String xrg;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(217940);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.xrc);
      if (this.xrd != null) {
        paramVarArgs.d(3, this.xrd);
      }
      if (this.xre != null) {
        paramVarArgs.d(4, this.xre);
      }
      if (this.xrf != null) {
        paramVarArgs.d(5, this.xrf);
      }
      if (this.xrg != null) {
        paramVarArgs.d(6, this.xrg);
      }
      AppMethodBeat.o(217940);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label598;
      }
    }
    label598:
    for (paramInt = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.xrc);
      paramInt = i;
      if (this.xrd != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.xrd);
      }
      i = paramInt;
      if (this.xre != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.xre);
      }
      paramInt = i;
      if (this.xrf != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.xrf);
      }
      i = paramInt;
      if (this.xrg != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.xrg);
      }
      AppMethodBeat.o(217940);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(217940);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        d locald = (d)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(217940);
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
            locald.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(217940);
          return 0;
        case 2: 
          locald.xrc = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(217940);
          return 0;
        case 3: 
          locald.xrd = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(217940);
          return 0;
        case 4: 
          locald.xre = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(217940);
          return 0;
        case 5: 
          locald.xrf = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(217940);
          return 0;
        }
        locald.xrg = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(217940);
        return 0;
      }
      AppMethodBeat.o(217940);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.d.d
 * JD-Core Version:    0.7.0.1
 */