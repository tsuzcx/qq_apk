package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class brn
  extends cvw
{
  public String Hej;
  public String Hel;
  public String Hem;
  public b Hen;
  public String Hep;
  public String cVJ;
  public String dwb;
  public String signature;
  public String url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(82442);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.url != null) {
        paramVarArgs.d(2, this.url);
      }
      if (this.dwb != null) {
        paramVarArgs.d(3, this.dwb);
      }
      if (this.Hej != null) {
        paramVarArgs.d(4, this.Hej);
      }
      if (this.cVJ != null) {
        paramVarArgs.d(5, this.cVJ);
      }
      if (this.Hel != null) {
        paramVarArgs.d(6, this.Hel);
      }
      if (this.signature != null) {
        paramVarArgs.d(7, this.signature);
      }
      if (this.Hem != null) {
        paramVarArgs.d(8, this.Hem);
      }
      if (this.Hen != null) {
        paramVarArgs.c(9, this.Hen);
      }
      if (this.Hep != null) {
        paramVarArgs.d(10, this.Hep);
      }
      AppMethodBeat.o(82442);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label862;
      }
    }
    label862:
    for (int i = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.url != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.url);
      }
      i = paramInt;
      if (this.dwb != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.dwb);
      }
      paramInt = i;
      if (this.Hej != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Hej);
      }
      i = paramInt;
      if (this.cVJ != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.cVJ);
      }
      paramInt = i;
      if (this.Hel != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.Hel);
      }
      i = paramInt;
      if (this.signature != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.signature);
      }
      paramInt = i;
      if (this.Hem != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.Hem);
      }
      i = paramInt;
      if (this.Hen != null) {
        i = paramInt + f.a.a.b.b.a.b(9, this.Hen);
      }
      paramInt = i;
      if (this.Hep != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.Hep);
      }
      AppMethodBeat.o(82442);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(82442);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        brn localbrn = (brn)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(82442);
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
            localbrn.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(82442);
          return 0;
        case 2: 
          localbrn.url = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(82442);
          return 0;
        case 3: 
          localbrn.dwb = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(82442);
          return 0;
        case 4: 
          localbrn.Hej = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(82442);
          return 0;
        case 5: 
          localbrn.cVJ = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(82442);
          return 0;
        case 6: 
          localbrn.Hel = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(82442);
          return 0;
        case 7: 
          localbrn.signature = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(82442);
          return 0;
        case 8: 
          localbrn.Hem = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(82442);
          return 0;
        case 9: 
          localbrn.Hen = ((f.a.a.a.a)localObject1).OmT.gCk();
          AppMethodBeat.o(82442);
          return 0;
        }
        localbrn.Hep = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(82442);
        return 0;
      }
      AppMethodBeat.o(82442);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.brn
 * JD-Core Version:    0.7.0.1
 */