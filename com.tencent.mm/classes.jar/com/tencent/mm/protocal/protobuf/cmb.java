package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class cmb
  extends cvw
{
  public String FKA;
  public long FKy;
  public String FKz;
  public b GTs;
  public int GaV;
  public String content;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(215597);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.GTs != null) {
        paramVarArgs.c(2, this.GTs);
      }
      paramVarArgs.aS(3, this.GaV);
      if (this.content != null) {
        paramVarArgs.d(4, this.content);
      }
      paramVarArgs.aZ(5, this.FKy);
      if (this.FKz != null) {
        paramVarArgs.d(6, this.FKz);
      }
      if (this.FKA != null) {
        paramVarArgs.d(7, this.FKA);
      }
      AppMethodBeat.o(215597);
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
      if (this.GTs != null) {
        i = paramInt + f.a.a.b.b.a.b(2, this.GTs);
      }
      i += f.a.a.b.b.a.bz(3, this.GaV);
      paramInt = i;
      if (this.content != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.content);
      }
      i = paramInt + f.a.a.b.b.a.p(5, this.FKy);
      paramInt = i;
      if (this.FKz != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.FKz);
      }
      i = paramInt;
      if (this.FKA != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.FKA);
      }
      AppMethodBeat.o(215597);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(215597);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cmb localcmb = (cmb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(215597);
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
            localcmb.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(215597);
          return 0;
        case 2: 
          localcmb.GTs = ((f.a.a.a.a)localObject1).OmT.gCk();
          AppMethodBeat.o(215597);
          return 0;
        case 3: 
          localcmb.GaV = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(215597);
          return 0;
        case 4: 
          localcmb.content = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(215597);
          return 0;
        case 5: 
          localcmb.FKy = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(215597);
          return 0;
        case 6: 
          localcmb.FKz = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(215597);
          return 0;
        }
        localcmb.FKA = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(215597);
        return 0;
      }
      AppMethodBeat.o(215597);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cmb
 * JD-Core Version:    0.7.0.1
 */