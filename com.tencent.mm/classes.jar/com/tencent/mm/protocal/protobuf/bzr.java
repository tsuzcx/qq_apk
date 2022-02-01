package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bzr
  extends com.tencent.mm.bx.a
{
  public int CreateTime;
  public int DWt;
  public String scR;
  public String uoY;
  public String upa;
  public String upb;
  public int upc;
  public String upd;
  public int upe;
  public int upf;
  public String upg;
  public String uph;
  public String upi;
  public String upj;
  public String upk;
  public int upl;
  public LinkedList<ctp> upm;
  
  public bzr()
  {
    AppMethodBeat.i(91596);
    this.upm = new LinkedList();
    AppMethodBeat.o(91596);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91597);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.uoY != null) {
        paramVarArgs.d(1, this.uoY);
      }
      paramVarArgs.aR(2, this.DWt);
      if (this.upa != null) {
        paramVarArgs.d(3, this.upa);
      }
      paramVarArgs.aR(4, this.CreateTime);
      if (this.upb != null) {
        paramVarArgs.d(5, this.upb);
      }
      paramVarArgs.aR(6, this.upc);
      if (this.upd != null) {
        paramVarArgs.d(7, this.upd);
      }
      paramVarArgs.aR(8, this.upe);
      paramVarArgs.aR(9, this.upf);
      if (this.upg != null) {
        paramVarArgs.d(10, this.upg);
      }
      if (this.scR != null) {
        paramVarArgs.d(11, this.scR);
      }
      if (this.uph != null) {
        paramVarArgs.d(12, this.uph);
      }
      if (this.upi != null) {
        paramVarArgs.d(13, this.upi);
      }
      if (this.upj != null) {
        paramVarArgs.d(14, this.upj);
      }
      if (this.upk != null) {
        paramVarArgs.d(15, this.upk);
      }
      paramVarArgs.aR(16, this.upl);
      paramVarArgs.e(17, 8, this.upm);
      AppMethodBeat.o(91597);
      return 0;
    }
    if (paramInt == 1) {
      if (this.uoY == null) {
        break label1186;
      }
    }
    label1186:
    for (paramInt = f.a.a.b.b.a.e(1, this.uoY) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.DWt);
      paramInt = i;
      if (this.upa != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.upa);
      }
      i = paramInt + f.a.a.b.b.a.bA(4, this.CreateTime);
      paramInt = i;
      if (this.upb != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.upb);
      }
      i = paramInt + f.a.a.b.b.a.bA(6, this.upc);
      paramInt = i;
      if (this.upd != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.upd);
      }
      i = paramInt + f.a.a.b.b.a.bA(8, this.upe) + f.a.a.b.b.a.bA(9, this.upf);
      paramInt = i;
      if (this.upg != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.upg);
      }
      i = paramInt;
      if (this.scR != null) {
        i = paramInt + f.a.a.b.b.a.e(11, this.scR);
      }
      paramInt = i;
      if (this.uph != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.uph);
      }
      i = paramInt;
      if (this.upi != null) {
        i = paramInt + f.a.a.b.b.a.e(13, this.upi);
      }
      paramInt = i;
      if (this.upj != null) {
        paramInt = i + f.a.a.b.b.a.e(14, this.upj);
      }
      i = paramInt;
      if (this.upk != null) {
        i = paramInt + f.a.a.b.b.a.e(15, this.upk);
      }
      paramInt = f.a.a.b.b.a.bA(16, this.upl);
      int j = f.a.a.a.c(17, 8, this.upm);
      AppMethodBeat.o(91597);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.upm.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(91597);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bzr localbzr = (bzr)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91597);
          return -1;
        case 1: 
          localbzr.uoY = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91597);
          return 0;
        case 2: 
          localbzr.DWt = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(91597);
          return 0;
        case 3: 
          localbzr.upa = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91597);
          return 0;
        case 4: 
          localbzr.CreateTime = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(91597);
          return 0;
        case 5: 
          localbzr.upb = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91597);
          return 0;
        case 6: 
          localbzr.upc = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(91597);
          return 0;
        case 7: 
          localbzr.upd = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91597);
          return 0;
        case 8: 
          localbzr.upe = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(91597);
          return 0;
        case 9: 
          localbzr.upf = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(91597);
          return 0;
        case 10: 
          localbzr.upg = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91597);
          return 0;
        case 11: 
          localbzr.scR = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91597);
          return 0;
        case 12: 
          localbzr.uph = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91597);
          return 0;
        case 13: 
          localbzr.upi = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91597);
          return 0;
        case 14: 
          localbzr.upj = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91597);
          return 0;
        case 15: 
          localbzr.upk = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91597);
          return 0;
        case 16: 
          localbzr.upl = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(91597);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ctp();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((ctp)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbzr.upm.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91597);
        return 0;
      }
      AppMethodBeat.o(91597);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bzr
 * JD-Core Version:    0.7.0.1
 */