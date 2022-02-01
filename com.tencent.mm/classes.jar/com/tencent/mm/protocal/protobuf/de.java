package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class de
  extends com.tencent.mm.bw.a
{
  public int Brl;
  public long Brn;
  public int CreateTime;
  public dqi KHl;
  public dqi KHm;
  public dqi KHn;
  public int KHo;
  public SKBuiltinBuffer_t KHp;
  public String KHq;
  public String KHr;
  public int KHs;
  public int oTW;
  public int xKb;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133143);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.KHl == null)
      {
        paramVarArgs = new b("Not all required fields were included: FromUserName");
        AppMethodBeat.o(133143);
        throw paramVarArgs;
      }
      if (this.KHm == null)
      {
        paramVarArgs = new b("Not all required fields were included: ToUserName");
        AppMethodBeat.o(133143);
        throw paramVarArgs;
      }
      if (this.KHn == null)
      {
        paramVarArgs = new b("Not all required fields were included: Content");
        AppMethodBeat.o(133143);
        throw paramVarArgs;
      }
      if (this.KHp == null)
      {
        paramVarArgs = new b("Not all required fields were included: ImgBuf");
        AppMethodBeat.o(133143);
        throw paramVarArgs;
      }
      paramVarArgs.aM(1, this.Brl);
      if (this.KHl != null)
      {
        paramVarArgs.ni(2, this.KHl.computeSize());
        this.KHl.writeFields(paramVarArgs);
      }
      if (this.KHm != null)
      {
        paramVarArgs.ni(3, this.KHm.computeSize());
        this.KHm.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(4, this.xKb);
      if (this.KHn != null)
      {
        paramVarArgs.ni(5, this.KHn.computeSize());
        this.KHn.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(6, this.oTW);
      paramVarArgs.aM(7, this.KHo);
      if (this.KHp != null)
      {
        paramVarArgs.ni(8, this.KHp.computeSize());
        this.KHp.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(9, this.CreateTime);
      if (this.KHq != null) {
        paramVarArgs.e(10, this.KHq);
      }
      if (this.KHr != null) {
        paramVarArgs.e(11, this.KHr);
      }
      paramVarArgs.bb(12, this.Brn);
      paramVarArgs.aM(13, this.KHs);
      AppMethodBeat.o(133143);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bu(1, this.Brl) + 0;
      paramInt = i;
      if (this.KHl != null) {
        paramInt = i + g.a.a.a.nh(2, this.KHl.computeSize());
      }
      i = paramInt;
      if (this.KHm != null) {
        i = paramInt + g.a.a.a.nh(3, this.KHm.computeSize());
      }
      i += g.a.a.b.b.a.bu(4, this.xKb);
      paramInt = i;
      if (this.KHn != null) {
        paramInt = i + g.a.a.a.nh(5, this.KHn.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bu(6, this.oTW) + g.a.a.b.b.a.bu(7, this.KHo);
      paramInt = i;
      if (this.KHp != null) {
        paramInt = i + g.a.a.a.nh(8, this.KHp.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bu(9, this.CreateTime);
      paramInt = i;
      if (this.KHq != null) {
        paramInt = i + g.a.a.b.b.a.f(10, this.KHq);
      }
      i = paramInt;
      if (this.KHr != null) {
        i = paramInt + g.a.a.b.b.a.f(11, this.KHr);
      }
      paramInt = g.a.a.b.b.a.r(12, this.Brn);
      int j = g.a.a.b.b.a.bu(13, this.KHs);
      AppMethodBeat.o(133143);
      return i + paramInt + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      if (this.KHl == null)
      {
        paramVarArgs = new b("Not all required fields were included: FromUserName");
        AppMethodBeat.o(133143);
        throw paramVarArgs;
      }
      if (this.KHm == null)
      {
        paramVarArgs = new b("Not all required fields were included: ToUserName");
        AppMethodBeat.o(133143);
        throw paramVarArgs;
      }
      if (this.KHn == null)
      {
        paramVarArgs = new b("Not all required fields were included: Content");
        AppMethodBeat.o(133143);
        throw paramVarArgs;
      }
      if (this.KHp == null)
      {
        paramVarArgs = new b("Not all required fields were included: ImgBuf");
        AppMethodBeat.o(133143);
        throw paramVarArgs;
      }
      AppMethodBeat.o(133143);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      de localde = (de)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(133143);
        return -1;
      case 1: 
        localde.Brl = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(133143);
        return 0;
      case 2: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dqi();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dqi)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localde.KHl = ((dqi)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(133143);
        return 0;
      case 3: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dqi();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dqi)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localde.KHm = ((dqi)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(133143);
        return 0;
      case 4: 
        localde.xKb = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(133143);
        return 0;
      case 5: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dqi();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dqi)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localde.KHn = ((dqi)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(133143);
        return 0;
      case 6: 
        localde.oTW = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(133143);
        return 0;
      case 7: 
        localde.KHo = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(133143);
        return 0;
      case 8: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localde.KHp = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(133143);
        return 0;
      case 9: 
        localde.CreateTime = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(133143);
        return 0;
      case 10: 
        localde.KHq = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(133143);
        return 0;
      case 11: 
        localde.KHr = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(133143);
        return 0;
      case 12: 
        localde.Brn = ((g.a.a.a.a)localObject1).UbS.zl();
        AppMethodBeat.o(133143);
        return 0;
      }
      localde.KHs = ((g.a.a.a.a)localObject1).UbS.zi();
      AppMethodBeat.o(133143);
      return 0;
    }
    AppMethodBeat.o(133143);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.de
 * JD-Core Version:    0.7.0.1
 */