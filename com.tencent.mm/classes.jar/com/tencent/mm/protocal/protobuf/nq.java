package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class nq
  extends cvw
{
  public LinkedList<ny> Gal;
  public int Gam;
  public int Gan;
  public String Gao;
  public long Gap;
  public String Gaq;
  public sx Gar;
  public np Gas;
  public fd Gat;
  public String Gau;
  
  public nq()
  {
    AppMethodBeat.i(188928);
    this.Gal = new LinkedList();
    AppMethodBeat.o(188928);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(188929);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.Gal);
      paramVarArgs.aS(3, this.Gam);
      paramVarArgs.aS(4, this.Gan);
      if (this.Gao != null) {
        paramVarArgs.d(5, this.Gao);
      }
      paramVarArgs.aZ(6, this.Gap);
      if (this.Gaq != null) {
        paramVarArgs.d(7, this.Gaq);
      }
      if (this.Gar != null)
      {
        paramVarArgs.lJ(8, this.Gar.computeSize());
        this.Gar.writeFields(paramVarArgs);
      }
      if (this.Gas != null)
      {
        paramVarArgs.lJ(9, this.Gas.computeSize());
        this.Gas.writeFields(paramVarArgs);
      }
      if (this.Gat != null)
      {
        paramVarArgs.lJ(10, this.Gat.computeSize());
        this.Gat.writeFields(paramVarArgs);
      }
      if (this.Gau != null) {
        paramVarArgs.d(11, this.Gau);
      }
      AppMethodBeat.o(188929);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1234;
      }
    }
    label1234:
    for (paramInt = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.a.c(2, 8, this.Gal) + f.a.a.b.b.a.bz(3, this.Gam) + f.a.a.b.b.a.bz(4, this.Gan);
      paramInt = i;
      if (this.Gao != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.Gao);
      }
      i = paramInt + f.a.a.b.b.a.p(6, this.Gap);
      paramInt = i;
      if (this.Gaq != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.Gaq);
      }
      i = paramInt;
      if (this.Gar != null) {
        i = paramInt + f.a.a.a.lI(8, this.Gar.computeSize());
      }
      paramInt = i;
      if (this.Gas != null) {
        paramInt = i + f.a.a.a.lI(9, this.Gas.computeSize());
      }
      i = paramInt;
      if (this.Gat != null) {
        i = paramInt + f.a.a.a.lI(10, this.Gat.computeSize());
      }
      paramInt = i;
      if (this.Gau != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.Gau);
      }
      AppMethodBeat.o(188929);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Gal.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(188929);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        nq localnq = (nq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(188929);
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
            localnq.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(188929);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ny();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ny)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localnq.Gal.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(188929);
          return 0;
        case 3: 
          localnq.Gam = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(188929);
          return 0;
        case 4: 
          localnq.Gan = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(188929);
          return 0;
        case 5: 
          localnq.Gao = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(188929);
          return 0;
        case 6: 
          localnq.Gap = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(188929);
          return 0;
        case 7: 
          localnq.Gaq = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(188929);
          return 0;
        case 8: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new sx();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((sx)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localnq.Gar = ((sx)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(188929);
          return 0;
        case 9: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new np();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((np)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localnq.Gas = ((np)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(188929);
          return 0;
        case 10: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new fd();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((fd)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localnq.Gat = ((fd)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(188929);
          return 0;
        }
        localnq.Gau = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(188929);
        return 0;
      }
      AppMethodBeat.o(188929);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.nq
 * JD-Core Version:    0.7.0.1
 */