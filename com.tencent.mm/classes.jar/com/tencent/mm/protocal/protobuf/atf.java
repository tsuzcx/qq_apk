package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class atf
  extends com.tencent.mm.bx.a
{
  public int CLL;
  public int DsC;
  public ckp Dth;
  public boolean Dtn;
  public boolean Dto;
  public String Dtp;
  public int dhR;
  public String md5;
  public String url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(175245);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.dhR);
      if (this.url != null) {
        paramVarArgs.d(2, this.url);
      }
      if (this.md5 != null) {
        paramVarArgs.d(3, this.md5);
      }
      paramVarArgs.aR(4, this.DsC);
      paramVarArgs.aR(5, this.CLL);
      paramVarArgs.bg(6, this.Dtn);
      paramVarArgs.bg(7, this.Dto);
      if (this.Dth != null)
      {
        paramVarArgs.kX(20, this.Dth.computeSize());
        this.Dth.writeFields(paramVarArgs);
      }
      if (this.Dtp != null) {
        paramVarArgs.d(21, this.Dtp);
      }
      AppMethodBeat.o(175245);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bA(1, this.dhR) + 0;
      paramInt = i;
      if (this.url != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.url);
      }
      i = paramInt;
      if (this.md5 != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.md5);
      }
      i = i + f.a.a.b.b.a.bA(4, this.DsC) + f.a.a.b.b.a.bA(5, this.CLL) + (f.a.a.b.b.a.fY(6) + 1) + (f.a.a.b.b.a.fY(7) + 1);
      paramInt = i;
      if (this.Dth != null) {
        paramInt = i + f.a.a.a.kW(20, this.Dth.computeSize());
      }
      i = paramInt;
      if (this.Dtp != null) {
        i = paramInt + f.a.a.b.b.a.e(21, this.Dtp);
      }
      AppMethodBeat.o(175245);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(175245);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      atf localatf = (atf)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      case 8: 
      case 9: 
      case 10: 
      case 11: 
      case 12: 
      case 13: 
      case 14: 
      case 15: 
      case 16: 
      case 17: 
      case 18: 
      case 19: 
      default: 
        AppMethodBeat.o(175245);
        return -1;
      case 1: 
        localatf.dhR = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(175245);
        return 0;
      case 2: 
        localatf.url = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(175245);
        return 0;
      case 3: 
        localatf.md5 = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(175245);
        return 0;
      case 4: 
        localatf.DsC = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(175245);
        return 0;
      case 5: 
        localatf.CLL = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(175245);
        return 0;
      case 6: 
        localatf.Dtn = ((f.a.a.a.a)localObject1).KhF.fHu();
        AppMethodBeat.o(175245);
        return 0;
      case 7: 
        localatf.Dto = ((f.a.a.a.a)localObject1).KhF.fHu();
        AppMethodBeat.o(175245);
        return 0;
      case 20: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ckp();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((ckp)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localatf.Dth = ((ckp)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(175245);
        return 0;
      }
      localatf.Dtp = ((f.a.a.a.a)localObject1).KhF.readString();
      AppMethodBeat.o(175245);
      return 0;
    }
    AppMethodBeat.o(175245);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.atf
 * JD-Core Version:    0.7.0.1
 */