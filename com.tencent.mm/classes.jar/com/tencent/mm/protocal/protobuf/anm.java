package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class anm
  extends cvw
{
  public alw GDR;
  public String GEX;
  public int opType;
  public long refObjectId;
  public String refObjectNonceId;
  public String sbR;
  public String sessionBuffer;
  public int vGk;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(168964);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.GEX != null) {
        paramVarArgs.d(2, this.GEX);
      }
      paramVarArgs.aS(3, this.opType);
      paramVarArgs.aZ(4, this.refObjectId);
      if (this.sbR != null) {
        paramVarArgs.d(5, this.sbR);
      }
      if (this.refObjectNonceId != null) {
        paramVarArgs.d(6, this.refObjectNonceId);
      }
      if (this.GDR != null)
      {
        paramVarArgs.lJ(7, this.GDR.computeSize());
        this.GDR.writeFields(paramVarArgs);
      }
      if (this.sessionBuffer != null) {
        paramVarArgs.d(8, this.sessionBuffer);
      }
      paramVarArgs.aS(9, this.vGk);
      AppMethodBeat.o(168964);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label842;
      }
    }
    label842:
    for (paramInt = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.GEX != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.GEX);
      }
      i = i + f.a.a.b.b.a.bz(3, this.opType) + f.a.a.b.b.a.p(4, this.refObjectId);
      paramInt = i;
      if (this.sbR != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.sbR);
      }
      i = paramInt;
      if (this.refObjectNonceId != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.refObjectNonceId);
      }
      paramInt = i;
      if (this.GDR != null) {
        paramInt = i + f.a.a.a.lI(7, this.GDR.computeSize());
      }
      i = paramInt;
      if (this.sessionBuffer != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.sessionBuffer);
      }
      paramInt = f.a.a.b.b.a.bz(9, this.vGk);
      AppMethodBeat.o(168964);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(168964);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        anm localanm = (anm)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(168964);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((jc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localanm.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(168964);
          return 0;
        case 2: 
          localanm.GEX = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(168964);
          return 0;
        case 3: 
          localanm.opType = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(168964);
          return 0;
        case 4: 
          localanm.refObjectId = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(168964);
          return 0;
        case 5: 
          localanm.sbR = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(168964);
          return 0;
        case 6: 
          localanm.refObjectNonceId = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(168964);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new alw();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((alw)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localanm.GDR = ((alw)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(168964);
          return 0;
        case 8: 
          localanm.sessionBuffer = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(168964);
          return 0;
        }
        localanm.vGk = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(168964);
        return 0;
      }
      AppMethodBeat.o(168964);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.anm
 * JD-Core Version:    0.7.0.1
 */