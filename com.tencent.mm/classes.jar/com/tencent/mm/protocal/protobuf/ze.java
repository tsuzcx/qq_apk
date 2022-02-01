package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ze
  extends dop
{
  public int KHd;
  public String KPJ;
  public bf Lcc;
  public String Ljk;
  public String Lkp;
  public String Lkq;
  public String Lkr;
  public String Lks;
  public int Lkt;
  public String Lku;
  public int Lkv;
  public String Lkw;
  public String UserName;
  public String jfi;
  public String xut;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91416);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.jfi != null) {
        paramVarArgs.e(2, this.jfi);
      }
      if (this.Lkp != null) {
        paramVarArgs.e(3, this.Lkp);
      }
      if (this.KPJ != null) {
        paramVarArgs.e(4, this.KPJ);
      }
      if (this.Lkq != null) {
        paramVarArgs.e(5, this.Lkq);
      }
      if (this.Lkr != null) {
        paramVarArgs.e(6, this.Lkr);
      }
      if (this.Lks != null) {
        paramVarArgs.e(7, this.Lks);
      }
      if (this.Ljk != null) {
        paramVarArgs.e(8, this.Ljk);
      }
      paramVarArgs.aM(9, this.Lkt);
      if (this.Lcc != null)
      {
        paramVarArgs.ni(10, this.Lcc.computeSize());
        this.Lcc.writeFields(paramVarArgs);
      }
      if (this.Lku != null) {
        paramVarArgs.e(11, this.Lku);
      }
      if (this.UserName != null) {
        paramVarArgs.e(12, this.UserName);
      }
      if (this.xut != null) {
        paramVarArgs.e(13, this.xut);
      }
      paramVarArgs.aM(14, this.KHd);
      paramVarArgs.aM(15, this.Lkv);
      if (this.Lkw != null) {
        paramVarArgs.e(16, this.Lkw);
      }
      AppMethodBeat.o(91416);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1278;
      }
    }
    label1278:
    for (int i = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.jfi != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.jfi);
      }
      i = paramInt;
      if (this.Lkp != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.Lkp);
      }
      paramInt = i;
      if (this.KPJ != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.KPJ);
      }
      i = paramInt;
      if (this.Lkq != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.Lkq);
      }
      paramInt = i;
      if (this.Lkr != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.Lkr);
      }
      i = paramInt;
      if (this.Lks != null) {
        i = paramInt + g.a.a.b.b.a.f(7, this.Lks);
      }
      paramInt = i;
      if (this.Ljk != null) {
        paramInt = i + g.a.a.b.b.a.f(8, this.Ljk);
      }
      i = paramInt + g.a.a.b.b.a.bu(9, this.Lkt);
      paramInt = i;
      if (this.Lcc != null) {
        paramInt = i + g.a.a.a.nh(10, this.Lcc.computeSize());
      }
      i = paramInt;
      if (this.Lku != null) {
        i = paramInt + g.a.a.b.b.a.f(11, this.Lku);
      }
      paramInt = i;
      if (this.UserName != null) {
        paramInt = i + g.a.a.b.b.a.f(12, this.UserName);
      }
      i = paramInt;
      if (this.xut != null) {
        i = paramInt + g.a.a.b.b.a.f(13, this.xut);
      }
      i = i + g.a.a.b.b.a.bu(14, this.KHd) + g.a.a.b.b.a.bu(15, this.Lkv);
      paramInt = i;
      if (this.Lkw != null) {
        paramInt = i + g.a.a.b.b.a.f(16, this.Lkw);
      }
      AppMethodBeat.o(91416);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(91416);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        ze localze = (ze)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91416);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jr();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((jr)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localze.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91416);
          return 0;
        case 2: 
          localze.jfi = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91416);
          return 0;
        case 3: 
          localze.Lkp = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91416);
          return 0;
        case 4: 
          localze.KPJ = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91416);
          return 0;
        case 5: 
          localze.Lkq = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91416);
          return 0;
        case 6: 
          localze.Lkr = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91416);
          return 0;
        case 7: 
          localze.Lks = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91416);
          return 0;
        case 8: 
          localze.Ljk = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91416);
          return 0;
        case 9: 
          localze.Lkt = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91416);
          return 0;
        case 10: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bf();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bf)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localze.Lcc = ((bf)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91416);
          return 0;
        case 11: 
          localze.Lku = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91416);
          return 0;
        case 12: 
          localze.UserName = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91416);
          return 0;
        case 13: 
          localze.xut = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91416);
          return 0;
        case 14: 
          localze.KHd = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91416);
          return 0;
        case 15: 
          localze.Lkv = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91416);
          return 0;
        }
        localze.Lkw = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(91416);
        return 0;
      }
      AppMethodBeat.o(91416);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ze
 * JD-Core Version:    0.7.0.1
 */