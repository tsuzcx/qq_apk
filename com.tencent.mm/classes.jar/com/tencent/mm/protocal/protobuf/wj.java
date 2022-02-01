package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class wj
  extends cvw
{
  public int FQT;
  public long FSx;
  public String FSy;
  public String Ghg;
  public String Goe;
  public String Gof;
  public String uvF;
  public String uvG;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(9586);
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
      if (this.uvF != null) {
        paramVarArgs.d(3, this.uvF);
      }
      paramVarArgs.aZ(4, this.FSx);
      if (this.Ghg != null) {
        paramVarArgs.d(5, this.Ghg);
      }
      if (this.Goe != null) {
        paramVarArgs.d(6, this.Goe);
      }
      paramVarArgs.aS(7, this.FQT);
      if (this.FSy != null) {
        paramVarArgs.d(8, this.FSy);
      }
      if (this.Gof != null) {
        paramVarArgs.d(9, this.Gof);
      }
      AppMethodBeat.o(9586);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label781;
      }
    }
    label781:
    for (int i = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.uvG != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.uvG);
      }
      i = paramInt;
      if (this.uvF != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.uvF);
      }
      i += f.a.a.b.b.a.p(4, this.FSx);
      paramInt = i;
      if (this.Ghg != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.Ghg);
      }
      i = paramInt;
      if (this.Goe != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.Goe);
      }
      i += f.a.a.b.b.a.bz(7, this.FQT);
      paramInt = i;
      if (this.FSy != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.FSy);
      }
      i = paramInt;
      if (this.Gof != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.Gof);
      }
      AppMethodBeat.o(9586);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(9586);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        wj localwj = (wj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(9586);
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
            localwj.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(9586);
          return 0;
        case 2: 
          localwj.uvG = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(9586);
          return 0;
        case 3: 
          localwj.uvF = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(9586);
          return 0;
        case 4: 
          localwj.FSx = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(9586);
          return 0;
        case 5: 
          localwj.Ghg = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(9586);
          return 0;
        case 6: 
          localwj.Goe = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(9586);
          return 0;
        case 7: 
          localwj.FQT = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(9586);
          return 0;
        case 8: 
          localwj.FSy = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(9586);
          return 0;
        }
        localwj.Gof = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(9586);
        return 0;
      }
      AppMethodBeat.o(9586);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.wj
 * JD-Core Version:    0.7.0.1
 */