package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class bdo
  extends com.tencent.mm.bw.a
{
  public String Bvg;
  public int LNm;
  public int LNn;
  public b LNo;
  public LinkedList<String> LNp;
  public aaw LNq;
  public int count;
  public String path;
  public String qGB;
  public String title;
  public int xGz;
  
  public bdo()
  {
    AppMethodBeat.i(209701);
    this.LNp = new LinkedList();
    AppMethodBeat.o(209701);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(184212);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.xGz);
      paramVarArgs.aM(2, this.count);
      if (this.title != null) {
        paramVarArgs.e(3, this.title);
      }
      if (this.qGB != null) {
        paramVarArgs.e(4, this.qGB);
      }
      paramVarArgs.aM(5, this.LNm);
      if (this.path != null) {
        paramVarArgs.e(6, this.path);
      }
      if (this.Bvg != null) {
        paramVarArgs.e(7, this.Bvg);
      }
      paramVarArgs.aM(8, this.LNn);
      if (this.LNo != null) {
        paramVarArgs.c(9, this.LNo);
      }
      paramVarArgs.e(10, 1, this.LNp);
      if (this.LNq != null)
      {
        paramVarArgs.ni(11, this.LNq.computeSize());
        this.LNq.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(184212);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bu(1, this.xGz) + 0 + g.a.a.b.b.a.bu(2, this.count);
      paramInt = i;
      if (this.title != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.title);
      }
      i = paramInt;
      if (this.qGB != null) {
        i = paramInt + g.a.a.b.b.a.f(4, this.qGB);
      }
      i += g.a.a.b.b.a.bu(5, this.LNm);
      paramInt = i;
      if (this.path != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.path);
      }
      i = paramInt;
      if (this.Bvg != null) {
        i = paramInt + g.a.a.b.b.a.f(7, this.Bvg);
      }
      i += g.a.a.b.b.a.bu(8, this.LNn);
      paramInt = i;
      if (this.LNo != null) {
        paramInt = i + g.a.a.b.b.a.b(9, this.LNo);
      }
      i = paramInt + g.a.a.a.c(10, 1, this.LNp);
      paramInt = i;
      if (this.LNq != null) {
        paramInt = i + g.a.a.a.nh(11, this.LNq.computeSize());
      }
      AppMethodBeat.o(184212);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.LNp.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(184212);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      bdo localbdo = (bdo)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(184212);
        return -1;
      case 1: 
        localbdo.xGz = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(184212);
        return 0;
      case 2: 
        localbdo.count = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(184212);
        return 0;
      case 3: 
        localbdo.title = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(184212);
        return 0;
      case 4: 
        localbdo.qGB = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(184212);
        return 0;
      case 5: 
        localbdo.LNm = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(184212);
        return 0;
      case 6: 
        localbdo.path = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(184212);
        return 0;
      case 7: 
        localbdo.Bvg = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(184212);
        return 0;
      case 8: 
        localbdo.LNn = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(184212);
        return 0;
      case 9: 
        localbdo.LNo = ((g.a.a.a.a)localObject1).UbS.hPo();
        AppMethodBeat.o(184212);
        return 0;
      case 10: 
        localbdo.LNp.add(((g.a.a.a.a)localObject1).UbS.readString());
        AppMethodBeat.o(184212);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new aaw();
        localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (boolean bool = true; bool; bool = ((aaw)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
        localbdo.LNq = ((aaw)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(184212);
      return 0;
    }
    AppMethodBeat.o(184212);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bdo
 * JD-Core Version:    0.7.0.1
 */