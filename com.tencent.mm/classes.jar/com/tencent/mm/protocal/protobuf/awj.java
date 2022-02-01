package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class awj
  extends com.tencent.mm.bw.a
{
  public int ENG;
  public cpw EOl;
  public boolean EOr;
  public boolean EOs;
  public String EOt;
  public int Eeo;
  public int dfm;
  public String md5;
  public String url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(175245);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.dfm);
      if (this.url != null) {
        paramVarArgs.d(2, this.url);
      }
      if (this.md5 != null) {
        paramVarArgs.d(3, this.md5);
      }
      paramVarArgs.aR(4, this.ENG);
      paramVarArgs.aR(5, this.Eeo);
      paramVarArgs.bl(6, this.EOr);
      paramVarArgs.bl(7, this.EOs);
      if (this.EOl != null)
      {
        paramVarArgs.ln(20, this.EOl.computeSize());
        this.EOl.writeFields(paramVarArgs);
      }
      if (this.EOt != null) {
        paramVarArgs.d(21, this.EOt);
      }
      AppMethodBeat.o(175245);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bx(1, this.dfm) + 0;
      paramInt = i;
      if (this.url != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.url);
      }
      i = paramInt;
      if (this.md5 != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.md5);
      }
      i = i + f.a.a.b.b.a.bx(4, this.ENG) + f.a.a.b.b.a.bx(5, this.Eeo) + (f.a.a.b.b.a.fK(6) + 1) + (f.a.a.b.b.a.fK(7) + 1);
      paramInt = i;
      if (this.EOl != null) {
        paramInt = i + f.a.a.a.lm(20, this.EOl.computeSize());
      }
      i = paramInt;
      if (this.EOt != null) {
        i = paramInt + f.a.a.b.b.a.e(21, this.EOt);
      }
      AppMethodBeat.o(175245);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(175245);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      awj localawj = (awj)paramVarArgs[1];
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
        localawj.dfm = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(175245);
        return 0;
      case 2: 
        localawj.url = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(175245);
        return 0;
      case 3: 
        localawj.md5 = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(175245);
        return 0;
      case 4: 
        localawj.ENG = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(175245);
        return 0;
      case 5: 
        localawj.Eeo = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(175245);
        return 0;
      case 6: 
        localawj.EOr = ((f.a.a.a.a)localObject1).LVo.fZX();
        AppMethodBeat.o(175245);
        return 0;
      case 7: 
        localawj.EOs = ((f.a.a.a.a)localObject1).LVo.fZX();
        AppMethodBeat.o(175245);
        return 0;
      case 20: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cpw();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((cpw)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localawj.EOl = ((cpw)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(175245);
        return 0;
      }
      localawj.EOt = ((f.a.a.a.a)localObject1).LVo.readString();
      AppMethodBeat.o(175245);
      return 0;
    }
    AppMethodBeat.o(175245);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.awj
 * JD-Core Version:    0.7.0.1
 */