package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class f
  extends ckq
{
  public String Csj;
  public int Csl;
  public long Csm;
  public LinkedList<String> Csn;
  public az Cso;
  public long Csp;
  public String Csq;
  public String Csr;
  public String Css;
  public int scene;
  public String title;
  
  public f()
  {
    AppMethodBeat.i(91315);
    this.Csn = new LinkedList();
    AppMethodBeat.o(91315);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91316);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.Csl);
      paramVarArgs.aG(3, this.Csm);
      if (this.title != null) {
        paramVarArgs.d(4, this.title);
      }
      paramVarArgs.e(5, 1, this.Csn);
      paramVarArgs.aR(6, this.scene);
      if (this.Csj != null) {
        paramVarArgs.d(7, this.Csj);
      }
      if (this.Cso != null)
      {
        paramVarArgs.kX(8, this.Cso.computeSize());
        this.Cso.writeFields(paramVarArgs);
      }
      paramVarArgs.aG(9, this.Csp);
      if (this.Csq != null) {
        paramVarArgs.d(10, this.Csq);
      }
      if (this.Csr != null) {
        paramVarArgs.d(11, this.Csr);
      }
      if (this.Css != null) {
        paramVarArgs.d(12, this.Css);
      }
      AppMethodBeat.o(91316);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1010;
      }
    }
    label1010:
    for (paramInt = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.Csl) + f.a.a.b.b.a.q(3, this.Csm);
      paramInt = i;
      if (this.title != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.title);
      }
      i = paramInt + f.a.a.a.c(5, 1, this.Csn) + f.a.a.b.b.a.bA(6, this.scene);
      paramInt = i;
      if (this.Csj != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.Csj);
      }
      i = paramInt;
      if (this.Cso != null) {
        i = paramInt + f.a.a.a.kW(8, this.Cso.computeSize());
      }
      i += f.a.a.b.b.a.q(9, this.Csp);
      paramInt = i;
      if (this.Csq != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.Csq);
      }
      i = paramInt;
      if (this.Csr != null) {
        i = paramInt + f.a.a.b.b.a.e(11, this.Csr);
      }
      paramInt = i;
      if (this.Css != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.Css);
      }
      AppMethodBeat.o(91316);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Csn.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(91316);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        f localf = (f)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91316);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ip();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ip)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localf.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91316);
          return 0;
        case 2: 
          localf.Csl = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(91316);
          return 0;
        case 3: 
          localf.Csm = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(91316);
          return 0;
        case 4: 
          localf.title = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91316);
          return 0;
        case 5: 
          localf.Csn.add(((f.a.a.a.a)localObject1).KhF.readString());
          AppMethodBeat.o(91316);
          return 0;
        case 6: 
          localf.scene = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(91316);
          return 0;
        case 7: 
          localf.Csj = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91316);
          return 0;
        case 8: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new az();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((az)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localf.Cso = ((az)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91316);
          return 0;
        case 9: 
          localf.Csp = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(91316);
          return 0;
        case 10: 
          localf.Csq = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91316);
          return 0;
        case 11: 
          localf.Csr = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91316);
          return 0;
        }
        localf.Css = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(91316);
        return 0;
      }
      AppMethodBeat.o(91316);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.f
 * JD-Core Version:    0.7.0.1
 */