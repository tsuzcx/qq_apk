package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class hr
  extends ckq
{
  public int CCF;
  public LinkedList<yf> CCG;
  public String CCH;
  public String CCI;
  public String CCJ;
  public int Scene;
  public long mBe;
  
  public hr()
  {
    AppMethodBeat.i(32133);
    this.CCG = new LinkedList();
    AppMethodBeat.o(32133);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32134);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.CCF);
      paramVarArgs.e(3, 8, this.CCG);
      if (this.CCH != null) {
        paramVarArgs.d(4, this.CCH);
      }
      if (this.CCI != null) {
        paramVarArgs.d(5, this.CCI);
      }
      paramVarArgs.aR(6, this.Scene);
      paramVarArgs.aG(7, this.mBe);
      if (this.CCJ != null) {
        paramVarArgs.d(8, this.CCJ);
      }
      AppMethodBeat.o(32134);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label780;
      }
    }
    label780:
    for (paramInt = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.CCF) + f.a.a.a.c(3, 8, this.CCG);
      paramInt = i;
      if (this.CCH != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.CCH);
      }
      i = paramInt;
      if (this.CCI != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.CCI);
      }
      i = i + f.a.a.b.b.a.bA(6, this.Scene) + f.a.a.b.b.a.q(7, this.mBe);
      paramInt = i;
      if (this.CCJ != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.CCJ);
      }
      AppMethodBeat.o(32134);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.CCG.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(32134);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        hr localhr = (hr)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32134);
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
            localhr.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32134);
          return 0;
        case 2: 
          localhr.CCF = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(32134);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new yf();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((yf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localhr.CCG.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32134);
          return 0;
        case 4: 
          localhr.CCH = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(32134);
          return 0;
        case 5: 
          localhr.CCI = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(32134);
          return 0;
        case 6: 
          localhr.Scene = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(32134);
          return 0;
        case 7: 
          localhr.mBe = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(32134);
          return 0;
        }
        localhr.CCJ = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(32134);
        return 0;
      }
      AppMethodBeat.o(32134);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.hr
 * JD-Core Version:    0.7.0.1
 */