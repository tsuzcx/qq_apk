package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bdi
  extends cvw
{
  public String GRl;
  public int GSK;
  public int zQm;
  public long zQo;
  public String zot;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125732);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aZ(2, this.zQo);
      paramVarArgs.aS(3, this.GSK);
      if (this.GRl != null) {
        paramVarArgs.d(4, this.GRl);
      }
      if (this.zot != null) {
        paramVarArgs.d(5, this.zot);
      }
      paramVarArgs.aS(6, this.zQm);
      AppMethodBeat.o(125732);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label562;
      }
    }
    label562:
    for (paramInt = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.p(2, this.zQo) + f.a.a.b.b.a.bz(3, this.GSK);
      paramInt = i;
      if (this.GRl != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.GRl);
      }
      i = paramInt;
      if (this.zot != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.zot);
      }
      paramInt = f.a.a.b.b.a.bz(6, this.zQm);
      AppMethodBeat.o(125732);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(125732);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bdi localbdi = (bdi)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125732);
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
            localbdi.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125732);
          return 0;
        case 2: 
          localbdi.zQo = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(125732);
          return 0;
        case 3: 
          localbdi.GSK = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(125732);
          return 0;
        case 4: 
          localbdi.GRl = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(125732);
          return 0;
        case 5: 
          localbdi.zot = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(125732);
          return 0;
        }
        localbdi.zQm = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(125732);
        return 0;
      }
      AppMethodBeat.o(125732);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bdi
 * JD-Core Version:    0.7.0.1
 */