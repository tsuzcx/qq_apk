package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class beb
  extends dop
{
  public long DIf;
  public String LAt;
  public int LAu;
  public apc LAv;
  public int dLS;
  public String firstPageMD5;
  public b lastBuffer;
  public long twp;
  public aov uli;
  public String username;
  public int vkj;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169070);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.username != null) {
        paramVarArgs.e(2, this.username);
      }
      paramVarArgs.bb(3, this.DIf);
      if (this.firstPageMD5 != null) {
        paramVarArgs.e(4, this.firstPageMD5);
      }
      if (this.LAt != null) {
        paramVarArgs.e(5, this.LAt);
      }
      paramVarArgs.aM(6, this.LAu);
      if (this.uli != null)
      {
        paramVarArgs.ni(7, this.uli.computeSize());
        this.uli.writeFields(paramVarArgs);
      }
      if (this.lastBuffer != null) {
        paramVarArgs.c(8, this.lastBuffer);
      }
      paramVarArgs.aM(9, this.vkj);
      if (this.LAv != null)
      {
        paramVarArgs.ni(10, this.LAv.computeSize());
        this.LAv.writeFields(paramVarArgs);
      }
      paramVarArgs.bb(11, this.twp);
      paramVarArgs.aM(12, this.dLS);
      AppMethodBeat.o(169070);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1094;
      }
    }
    label1094:
    for (paramInt = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.username != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.username);
      }
      i += g.a.a.b.b.a.r(3, this.DIf);
      paramInt = i;
      if (this.firstPageMD5 != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.firstPageMD5);
      }
      i = paramInt;
      if (this.LAt != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.LAt);
      }
      i += g.a.a.b.b.a.bu(6, this.LAu);
      paramInt = i;
      if (this.uli != null) {
        paramInt = i + g.a.a.a.nh(7, this.uli.computeSize());
      }
      i = paramInt;
      if (this.lastBuffer != null) {
        i = paramInt + g.a.a.b.b.a.b(8, this.lastBuffer);
      }
      i += g.a.a.b.b.a.bu(9, this.vkj);
      paramInt = i;
      if (this.LAv != null) {
        paramInt = i + g.a.a.a.nh(10, this.LAv.computeSize());
      }
      i = g.a.a.b.b.a.r(11, this.twp);
      int j = g.a.a.b.b.a.bu(12, this.dLS);
      AppMethodBeat.o(169070);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(169070);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        beb localbeb = (beb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(169070);
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
            localbeb.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169070);
          return 0;
        case 2: 
          localbeb.username = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(169070);
          return 0;
        case 3: 
          localbeb.DIf = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(169070);
          return 0;
        case 4: 
          localbeb.firstPageMD5 = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(169070);
          return 0;
        case 5: 
          localbeb.LAt = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(169070);
          return 0;
        case 6: 
          localbeb.LAu = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(169070);
          return 0;
        case 7: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aov();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aov)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbeb.uli = ((aov)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169070);
          return 0;
        case 8: 
          localbeb.lastBuffer = ((g.a.a.a.a)localObject1).UbS.hPo();
          AppMethodBeat.o(169070);
          return 0;
        case 9: 
          localbeb.vkj = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(169070);
          return 0;
        case 10: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new apc();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((apc)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbeb.LAv = ((apc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169070);
          return 0;
        case 11: 
          localbeb.twp = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(169070);
          return 0;
        }
        localbeb.dLS = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(169070);
        return 0;
      }
      AppMethodBeat.o(169070);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.beb
 * JD-Core Version:    0.7.0.1
 */