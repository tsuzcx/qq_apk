package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class bhg
  extends com.tencent.mm.bw.a
{
  public int KCD;
  public int LQY;
  public String LRh;
  public String LRi;
  public String LRj;
  public String LRk;
  public String LRl;
  public int LRm;
  public int LRn;
  public int LRo;
  public b LRp;
  public LinkedList<ccc> LRq;
  public String Title;
  public String UserName;
  public String iAc;
  public String xJH;
  
  public bhg()
  {
    AppMethodBeat.i(223887);
    this.LRq = new LinkedList();
    AppMethodBeat.o(223887);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152549);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.LQY);
      if (this.LRh != null) {
        paramVarArgs.e(2, this.LRh);
      }
      if (this.LRi != null) {
        paramVarArgs.e(3, this.LRi);
      }
      paramVarArgs.aM(4, this.KCD);
      if (this.Title != null) {
        paramVarArgs.e(5, this.Title);
      }
      if (this.iAc != null) {
        paramVarArgs.e(6, this.iAc);
      }
      if (this.UserName != null) {
        paramVarArgs.e(7, this.UserName);
      }
      if (this.LRj != null) {
        paramVarArgs.e(8, this.LRj);
      }
      if (this.xJH != null) {
        paramVarArgs.e(10, this.xJH);
      }
      if (this.LRk != null) {
        paramVarArgs.e(11, this.LRk);
      }
      if (this.LRl != null) {
        paramVarArgs.e(12, this.LRl);
      }
      paramVarArgs.aM(13, this.LRm);
      paramVarArgs.aM(14, this.LRn);
      paramVarArgs.aM(15, this.LRo);
      if (this.LRp != null) {
        paramVarArgs.c(16, this.LRp);
      }
      paramVarArgs.e(17, 8, this.LRq);
      AppMethodBeat.o(152549);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bu(1, this.LQY) + 0;
      paramInt = i;
      if (this.LRh != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.LRh);
      }
      i = paramInt;
      if (this.LRi != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.LRi);
      }
      i += g.a.a.b.b.a.bu(4, this.KCD);
      paramInt = i;
      if (this.Title != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.Title);
      }
      i = paramInt;
      if (this.iAc != null) {
        i = paramInt + g.a.a.b.b.a.f(6, this.iAc);
      }
      paramInt = i;
      if (this.UserName != null) {
        paramInt = i + g.a.a.b.b.a.f(7, this.UserName);
      }
      i = paramInt;
      if (this.LRj != null) {
        i = paramInt + g.a.a.b.b.a.f(8, this.LRj);
      }
      paramInt = i;
      if (this.xJH != null) {
        paramInt = i + g.a.a.b.b.a.f(10, this.xJH);
      }
      i = paramInt;
      if (this.LRk != null) {
        i = paramInt + g.a.a.b.b.a.f(11, this.LRk);
      }
      paramInt = i;
      if (this.LRl != null) {
        paramInt = i + g.a.a.b.b.a.f(12, this.LRl);
      }
      i = paramInt + g.a.a.b.b.a.bu(13, this.LRm) + g.a.a.b.b.a.bu(14, this.LRn) + g.a.a.b.b.a.bu(15, this.LRo);
      paramInt = i;
      if (this.LRp != null) {
        paramInt = i + g.a.a.b.b.a.b(16, this.LRp);
      }
      i = g.a.a.a.c(17, 8, this.LRq);
      AppMethodBeat.o(152549);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.LRq.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(152549);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      bhg localbhg = (bhg)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      case 9: 
      default: 
        AppMethodBeat.o(152549);
        return -1;
      case 1: 
        localbhg.LQY = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(152549);
        return 0;
      case 2: 
        localbhg.LRh = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(152549);
        return 0;
      case 3: 
        localbhg.LRi = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(152549);
        return 0;
      case 4: 
        localbhg.KCD = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(152549);
        return 0;
      case 5: 
        localbhg.Title = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(152549);
        return 0;
      case 6: 
        localbhg.iAc = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(152549);
        return 0;
      case 7: 
        localbhg.UserName = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(152549);
        return 0;
      case 8: 
        localbhg.LRj = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(152549);
        return 0;
      case 10: 
        localbhg.xJH = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(152549);
        return 0;
      case 11: 
        localbhg.LRk = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(152549);
        return 0;
      case 12: 
        localbhg.LRl = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(152549);
        return 0;
      case 13: 
        localbhg.LRm = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(152549);
        return 0;
      case 14: 
        localbhg.LRn = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(152549);
        return 0;
      case 15: 
        localbhg.LRo = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(152549);
        return 0;
      case 16: 
        localbhg.LRp = ((g.a.a.a.a)localObject1).UbS.hPo();
        AppMethodBeat.o(152549);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new ccc();
        localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (boolean bool = true; bool; bool = ((ccc)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
        localbhg.LRq.add(localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(152549);
      return 0;
    }
    AppMethodBeat.o(152549);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bhg
 * JD-Core Version:    0.7.0.1
 */