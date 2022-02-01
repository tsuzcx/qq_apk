package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class h
  extends ckq
{
  public String Csj;
  public LinkedList<j> Csn;
  public az Cso;
  public long Csp;
  public String Csq;
  public String Csr;
  public String Css;
  public long Csv;
  public int scene;
  public String title;
  
  public h()
  {
    AppMethodBeat.i(91318);
    this.Csn = new LinkedList();
    AppMethodBeat.o(91318);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91319);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.title != null) {
        paramVarArgs.d(2, this.title);
      }
      paramVarArgs.aG(3, this.Csv);
      paramVarArgs.e(5, 8, this.Csn);
      paramVarArgs.aR(7, this.scene);
      if (this.Csj != null) {
        paramVarArgs.d(8, this.Csj);
      }
      if (this.Cso != null)
      {
        paramVarArgs.kX(9, this.Cso.computeSize());
        this.Cso.writeFields(paramVarArgs);
      }
      paramVarArgs.aG(10, this.Csp);
      if (this.Csq != null) {
        paramVarArgs.d(11, this.Csq);
      }
      if (this.Csr != null) {
        paramVarArgs.d(12, this.Csr);
      }
      if (this.Css != null) {
        paramVarArgs.d(13, this.Css);
      }
      AppMethodBeat.o(91319);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1054;
      }
    }
    label1054:
    for (paramInt = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.title != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.title);
      }
      i = i + f.a.a.b.b.a.q(3, this.Csv) + f.a.a.a.c(5, 8, this.Csn) + f.a.a.b.b.a.bA(7, this.scene);
      paramInt = i;
      if (this.Csj != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.Csj);
      }
      i = paramInt;
      if (this.Cso != null) {
        i = paramInt + f.a.a.a.kW(9, this.Cso.computeSize());
      }
      i += f.a.a.b.b.a.q(10, this.Csp);
      paramInt = i;
      if (this.Csq != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.Csq);
      }
      i = paramInt;
      if (this.Csr != null) {
        i = paramInt + f.a.a.b.b.a.e(12, this.Csr);
      }
      paramInt = i;
      if (this.Css != null) {
        paramInt = i + f.a.a.b.b.a.e(13, this.Css);
      }
      AppMethodBeat.o(91319);
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
        AppMethodBeat.o(91319);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        h localh = (h)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 4: 
        case 6: 
        default: 
          AppMethodBeat.o(91319);
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
            localh.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91319);
          return 0;
        case 2: 
          localh.title = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91319);
          return 0;
        case 3: 
          localh.Csv = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(91319);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new j();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((j)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localh.Csn.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91319);
          return 0;
        case 7: 
          localh.scene = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(91319);
          return 0;
        case 8: 
          localh.Csj = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91319);
          return 0;
        case 9: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new az();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((az)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localh.Cso = ((az)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91319);
          return 0;
        case 10: 
          localh.Csp = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(91319);
          return 0;
        case 11: 
          localh.Csq = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91319);
          return 0;
        case 12: 
          localh.Csr = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91319);
          return 0;
        }
        localh.Css = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(91319);
        return 0;
      }
      AppMethodBeat.o(91319);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.h
 * JD-Core Version:    0.7.0.1
 */