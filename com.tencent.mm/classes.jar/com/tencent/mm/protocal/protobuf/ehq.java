package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ehq
  extends cvw
{
  public String HVl;
  public int Hew;
  public LinkedList<String> Ilf;
  public boolean Ilg;
  public String Ilh;
  public boolean Ili;
  public boolean Ilj;
  public String dwb;
  
  public ehq()
  {
    AppMethodBeat.i(153313);
    this.Ilf = new LinkedList();
    AppMethodBeat.o(153313);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153314);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.dwb != null) {
        paramVarArgs.d(2, this.dwb);
      }
      paramVarArgs.e(3, 1, this.Ilf);
      paramVarArgs.bC(4, this.Ilg);
      if (this.Ilh != null) {
        paramVarArgs.d(5, this.Ilh);
      }
      paramVarArgs.bC(6, this.Ili);
      if (this.HVl != null) {
        paramVarArgs.d(7, this.HVl);
      }
      paramVarArgs.bC(8, this.Ilj);
      paramVarArgs.aS(9, this.Hew);
      AppMethodBeat.o(153314);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label722;
      }
    }
    label722:
    for (paramInt = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.dwb != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.dwb);
      }
      i = i + f.a.a.a.c(3, 1, this.Ilf) + f.a.a.b.b.a.amF(4);
      paramInt = i;
      if (this.Ilh != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.Ilh);
      }
      i = paramInt + f.a.a.b.b.a.amF(6);
      paramInt = i;
      if (this.HVl != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.HVl);
      }
      i = f.a.a.b.b.a.amF(8);
      int j = f.a.a.b.b.a.bz(9, this.Hew);
      AppMethodBeat.o(153314);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Ilf.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(153314);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ehq localehq = (ehq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(153314);
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
            localehq.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153314);
          return 0;
        case 2: 
          localehq.dwb = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(153314);
          return 0;
        case 3: 
          localehq.Ilf.add(((f.a.a.a.a)localObject1).OmT.readString());
          AppMethodBeat.o(153314);
          return 0;
        case 4: 
          localehq.Ilg = ((f.a.a.a.a)localObject1).OmT.gvY();
          AppMethodBeat.o(153314);
          return 0;
        case 5: 
          localehq.Ilh = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(153314);
          return 0;
        case 6: 
          localehq.Ili = ((f.a.a.a.a)localObject1).OmT.gvY();
          AppMethodBeat.o(153314);
          return 0;
        case 7: 
          localehq.HVl = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(153314);
          return 0;
        case 8: 
          localehq.Ilj = ((f.a.a.a.a)localObject1).OmT.gvY();
          AppMethodBeat.o(153314);
          return 0;
        }
        localehq.Hew = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(153314);
        return 0;
      }
      AppMethodBeat.o(153314);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ehq
 * JD-Core Version:    0.7.0.1
 */