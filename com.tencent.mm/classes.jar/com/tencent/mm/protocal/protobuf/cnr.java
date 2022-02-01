package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cnr
  extends cvw
{
  public int GqB;
  public int HzF;
  public int HzG;
  public int HzH;
  public long Hzw;
  public int Hzx;
  public String Hzy;
  public String uvF;
  public String uvG;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32378);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.uvG != null) {
        paramVarArgs.d(2, this.uvG);
      }
      if (this.Hzy != null) {
        paramVarArgs.d(3, this.Hzy);
      }
      paramVarArgs.aS(4, this.GqB);
      paramVarArgs.aZ(5, this.Hzw);
      paramVarArgs.aS(6, this.Hzx);
      if (this.uvF != null) {
        paramVarArgs.d(7, this.uvF);
      }
      paramVarArgs.aS(8, this.HzG);
      paramVarArgs.aS(9, this.HzF);
      paramVarArgs.aS(10, this.HzH);
      AppMethodBeat.o(32378);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label782;
      }
    }
    label782:
    for (int i = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.uvG != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.uvG);
      }
      i = paramInt;
      if (this.Hzy != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Hzy);
      }
      i = i + f.a.a.b.b.a.bz(4, this.GqB) + f.a.a.b.b.a.p(5, this.Hzw) + f.a.a.b.b.a.bz(6, this.Hzx);
      paramInt = i;
      if (this.uvF != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.uvF);
      }
      i = f.a.a.b.b.a.bz(8, this.HzG);
      int j = f.a.a.b.b.a.bz(9, this.HzF);
      int k = f.a.a.b.b.a.bz(10, this.HzH);
      AppMethodBeat.o(32378);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(32378);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cnr localcnr = (cnr)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32378);
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
            localcnr.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32378);
          return 0;
        case 2: 
          localcnr.uvG = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(32378);
          return 0;
        case 3: 
          localcnr.Hzy = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(32378);
          return 0;
        case 4: 
          localcnr.GqB = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(32378);
          return 0;
        case 5: 
          localcnr.Hzw = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(32378);
          return 0;
        case 6: 
          localcnr.Hzx = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(32378);
          return 0;
        case 7: 
          localcnr.uvF = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(32378);
          return 0;
        case 8: 
          localcnr.HzG = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(32378);
          return 0;
        case 9: 
          localcnr.HzF = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(32378);
          return 0;
        }
        localcnr.HzH = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(32378);
        return 0;
      }
      AppMethodBeat.o(32378);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cnr
 * JD-Core Version:    0.7.0.1
 */