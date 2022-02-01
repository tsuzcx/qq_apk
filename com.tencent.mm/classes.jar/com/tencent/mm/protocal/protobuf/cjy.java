package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cjy
  extends cvw
{
  public String FVY;
  public String Goz;
  public String GpD;
  public String GpE;
  public String GpF;
  public String GpG;
  public String ikm;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91590);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.ikm != null) {
        paramVarArgs.d(2, this.ikm);
      }
      if (this.GpD != null) {
        paramVarArgs.d(3, this.GpD);
      }
      if (this.FVY != null) {
        paramVarArgs.d(4, this.FVY);
      }
      if (this.GpE != null) {
        paramVarArgs.d(5, this.GpE);
      }
      if (this.GpF != null) {
        paramVarArgs.d(6, this.GpF);
      }
      if (this.GpG != null) {
        paramVarArgs.d(7, this.GpG);
      }
      if (this.Goz != null) {
        paramVarArgs.d(8, this.Goz);
      }
      AppMethodBeat.o(91590);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label738;
      }
    }
    label738:
    for (int i = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.ikm != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.ikm);
      }
      i = paramInt;
      if (this.GpD != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.GpD);
      }
      paramInt = i;
      if (this.FVY != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.FVY);
      }
      i = paramInt;
      if (this.GpE != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.GpE);
      }
      paramInt = i;
      if (this.GpF != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.GpF);
      }
      i = paramInt;
      if (this.GpG != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.GpG);
      }
      paramInt = i;
      if (this.Goz != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.Goz);
      }
      AppMethodBeat.o(91590);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(91590);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cjy localcjy = (cjy)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91590);
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
            localcjy.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91590);
          return 0;
        case 2: 
          localcjy.ikm = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91590);
          return 0;
        case 3: 
          localcjy.GpD = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91590);
          return 0;
        case 4: 
          localcjy.FVY = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91590);
          return 0;
        case 5: 
          localcjy.GpE = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91590);
          return 0;
        case 6: 
          localcjy.GpF = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91590);
          return 0;
        case 7: 
          localcjy.GpG = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91590);
          return 0;
        }
        localcjy.Goz = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(91590);
        return 0;
      }
      AppMethodBeat.o(91590);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cjy
 * JD-Core Version:    0.7.0.1
 */