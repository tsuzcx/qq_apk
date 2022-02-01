package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class vh
  extends cwj
{
  public String FOg;
  public String GmU;
  public String GmV;
  public String GmX;
  public String Gnj;
  public int dmy;
  public String dwj;
  public String phe;
  public int vxx;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72438);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(72438);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lJ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.dmy);
      if (this.phe != null) {
        paramVarArgs.d(3, this.phe);
      }
      if (this.dwj != null) {
        paramVarArgs.d(4, this.dwj);
      }
      if (this.GmX != null) {
        paramVarArgs.d(5, this.GmX);
      }
      if (this.FOg != null) {
        paramVarArgs.d(6, this.FOg);
      }
      paramVarArgs.aS(7, this.vxx);
      if (this.Gnj != null) {
        paramVarArgs.d(8, this.Gnj);
      }
      if (this.GmV != null) {
        paramVarArgs.d(9, this.GmV);
      }
      if (this.GmU != null) {
        paramVarArgs.d(10, this.GmU);
      }
      AppMethodBeat.o(72438);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label878;
      }
    }
    label878:
    for (paramInt = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.dmy);
      paramInt = i;
      if (this.phe != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.phe);
      }
      i = paramInt;
      if (this.dwj != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.dwj);
      }
      paramInt = i;
      if (this.GmX != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.GmX);
      }
      i = paramInt;
      if (this.FOg != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.FOg);
      }
      i += f.a.a.b.b.a.bz(7, this.vxx);
      paramInt = i;
      if (this.Gnj != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.Gnj);
      }
      i = paramInt;
      if (this.GmV != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.GmV);
      }
      paramInt = i;
      if (this.GmU != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.GmU);
      }
      AppMethodBeat.o(72438);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cwj.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cwj.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(72438);
          throw paramVarArgs;
        }
        AppMethodBeat.o(72438);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        vh localvh = (vh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72438);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localvh.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72438);
          return 0;
        case 2: 
          localvh.dmy = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(72438);
          return 0;
        case 3: 
          localvh.phe = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(72438);
          return 0;
        case 4: 
          localvh.dwj = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(72438);
          return 0;
        case 5: 
          localvh.GmX = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(72438);
          return 0;
        case 6: 
          localvh.FOg = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(72438);
          return 0;
        case 7: 
          localvh.vxx = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(72438);
          return 0;
        case 8: 
          localvh.Gnj = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(72438);
          return 0;
        case 9: 
          localvh.GmV = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(72438);
          return 0;
        }
        localvh.GmU = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(72438);
        return 0;
      }
      AppMethodBeat.o(72438);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.vh
 * JD-Core Version:    0.7.0.1
 */