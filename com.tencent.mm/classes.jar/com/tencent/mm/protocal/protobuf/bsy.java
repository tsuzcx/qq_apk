package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bsy
  extends cvw
{
  public String Hgv;
  public LinkedList<String> Hgy;
  public LinkedList<Integer> Hgz;
  
  public bsy()
  {
    AppMethodBeat.i(124524);
    this.Hgy = new LinkedList();
    this.Hgz = new LinkedList();
    AppMethodBeat.o(124524);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124525);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.Hgv != null) {
        paramVarArgs.d(2, this.Hgv);
      }
      paramVarArgs.e(3, 1, this.Hgy);
      paramVarArgs.e(4, 2, this.Hgz);
      AppMethodBeat.o(124525);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label493;
      }
    }
    label493:
    for (paramInt = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Hgv != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.Hgv);
      }
      paramInt = f.a.a.a.c(3, 1, this.Hgy);
      int j = f.a.a.a.c(4, 2, this.Hgz);
      AppMethodBeat.o(124525);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Hgy.clear();
        this.Hgz.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(124525);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bsy localbsy = (bsy)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(124525);
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
            localbsy.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124525);
          return 0;
        case 2: 
          localbsy.Hgv = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(124525);
          return 0;
        case 3: 
          localbsy.Hgy.add(((f.a.a.a.a)localObject1).OmT.readString());
          AppMethodBeat.o(124525);
          return 0;
        }
        localbsy.Hgz.add(Integer.valueOf(((f.a.a.a.a)localObject1).OmT.zc()));
        AppMethodBeat.o(124525);
        return 0;
      }
      AppMethodBeat.o(124525);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bsy
 * JD-Core Version:    0.7.0.1
 */