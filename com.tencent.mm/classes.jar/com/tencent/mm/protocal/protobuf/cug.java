package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cug
  extends dyl
{
  public int SfE;
  public long TBV;
  public long TBW;
  public long TBX;
  public int offset;
  public String query;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169915);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.bm(2, this.TBV);
      paramVarArgs.bm(3, this.TBW);
      if (this.query != null) {
        paramVarArgs.f(4, this.query);
      }
      paramVarArgs.aY(5, this.offset);
      paramVarArgs.aY(6, this.SfE);
      paramVarArgs.bm(7, this.TBX);
      AppMethodBeat.o(169915);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label576;
      }
    }
    label576:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.p(2, this.TBV) + g.a.a.b.b.a.p(3, this.TBW);
      paramInt = i;
      if (this.query != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.query);
      }
      i = g.a.a.b.b.a.bM(5, this.offset);
      int j = g.a.a.b.b.a.bM(6, this.SfE);
      int k = g.a.a.b.b.a.p(7, this.TBX);
      AppMethodBeat.o(169915);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(169915);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        cug localcug = (cug)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(169915);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            jg localjg = new jg();
            if ((localObject != null) && (localObject.length > 0)) {
              localjg.parseFrom((byte[])localObject);
            }
            localcug.BaseRequest = localjg;
            paramInt += 1;
          }
          AppMethodBeat.o(169915);
          return 0;
        case 2: 
          localcug.TBV = ((g.a.a.a.a)localObject).abFh.AN();
          AppMethodBeat.o(169915);
          return 0;
        case 3: 
          localcug.TBW = ((g.a.a.a.a)localObject).abFh.AN();
          AppMethodBeat.o(169915);
          return 0;
        case 4: 
          localcug.query = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(169915);
          return 0;
        case 5: 
          localcug.offset = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(169915);
          return 0;
        case 6: 
          localcug.SfE = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(169915);
          return 0;
        }
        localcug.TBX = ((g.a.a.a.a)localObject).abFh.AN();
        AppMethodBeat.o(169915);
        return 0;
      }
      AppMethodBeat.o(169915);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cug
 * JD-Core Version:    0.7.0.1
 */