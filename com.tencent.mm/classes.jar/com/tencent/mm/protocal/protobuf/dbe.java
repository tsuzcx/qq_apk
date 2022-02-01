package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dbe
  extends cvw
{
  public String HKh;
  public String HKi;
  public long zQo;
  public String zot;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(218305);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.HKh != null) {
        paramVarArgs.d(2, this.HKh);
      }
      if (this.zot != null) {
        paramVarArgs.d(3, this.zot);
      }
      paramVarArgs.aZ(4, this.zQo);
      if (this.HKi != null) {
        paramVarArgs.d(5, this.HKi);
      }
      AppMethodBeat.o(218305);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label534;
      }
    }
    label534:
    for (int i = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.HKh != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.HKh);
      }
      i = paramInt;
      if (this.zot != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.zot);
      }
      i += f.a.a.b.b.a.p(4, this.zQo);
      paramInt = i;
      if (this.HKi != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.HKi);
      }
      AppMethodBeat.o(218305);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(218305);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dbe localdbe = (dbe)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(218305);
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
            localdbe.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(218305);
          return 0;
        case 2: 
          localdbe.HKh = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(218305);
          return 0;
        case 3: 
          localdbe.zot = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(218305);
          return 0;
        case 4: 
          localdbe.zQo = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(218305);
          return 0;
        }
        localdbe.HKi = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(218305);
        return 0;
      }
      AppMethodBeat.o(218305);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dbe
 * JD-Core Version:    0.7.0.1
 */