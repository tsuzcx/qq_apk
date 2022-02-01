package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bxr
  extends cvw
{
  public int GjM;
  public long Hks;
  public long Hkt;
  public long Hku;
  public int offset;
  public String query;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169915);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aZ(2, this.Hks);
      paramVarArgs.aZ(3, this.Hkt);
      if (this.query != null) {
        paramVarArgs.d(4, this.query);
      }
      paramVarArgs.aS(5, this.offset);
      paramVarArgs.aS(6, this.GjM);
      paramVarArgs.aZ(7, this.Hku);
      AppMethodBeat.o(169915);
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
      int i = paramInt + f.a.a.b.b.a.p(2, this.Hks) + f.a.a.b.b.a.p(3, this.Hkt);
      paramInt = i;
      if (this.query != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.query);
      }
      i = f.a.a.b.b.a.bz(5, this.offset);
      int j = f.a.a.b.b.a.bz(6, this.GjM);
      int k = f.a.a.b.b.a.p(7, this.Hku);
      AppMethodBeat.o(169915);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(169915);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bxr localbxr = (bxr)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(169915);
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
            localbxr.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169915);
          return 0;
        case 2: 
          localbxr.Hks = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(169915);
          return 0;
        case 3: 
          localbxr.Hkt = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(169915);
          return 0;
        case 4: 
          localbxr.query = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(169915);
          return 0;
        case 5: 
          localbxr.offset = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(169915);
          return 0;
        case 6: 
          localbxr.GjM = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(169915);
          return 0;
        }
        localbxr.Hku = ((f.a.a.a.a)localObject1).OmT.zd();
        AppMethodBeat.o(169915);
        return 0;
      }
      AppMethodBeat.o(169915);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bxr
 * JD-Core Version:    0.7.0.1
 */