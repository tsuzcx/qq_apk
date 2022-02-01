package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class auo
  extends dop
{
  public int LFt;
  public String LFu;
  public LinkedList<Integer> LFv;
  public long commentId;
  public long hFK;
  public String objectNonceId;
  public int opType;
  public int scene;
  public String sessionBuffer;
  public long tsR;
  public int uFa;
  public aov uli;
  public String username;
  public int vkk;
  
  public auo()
  {
    AppMethodBeat.i(209481);
    this.LFv = new LinkedList();
    AppMethodBeat.o(209481);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169002);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.bb(2, this.hFK);
      paramVarArgs.bb(3, this.commentId);
      paramVarArgs.aM(4, this.opType);
      paramVarArgs.bb(5, this.tsR);
      paramVarArgs.aM(6, this.LFt);
      if (this.username != null) {
        paramVarArgs.e(7, this.username);
      }
      paramVarArgs.aM(8, this.scene);
      if (this.objectNonceId != null) {
        paramVarArgs.e(9, this.objectNonceId);
      }
      if (this.uli != null)
      {
        paramVarArgs.ni(10, this.uli.computeSize());
        this.uli.writeFields(paramVarArgs);
      }
      if (this.sessionBuffer != null) {
        paramVarArgs.e(11, this.sessionBuffer);
      }
      if (this.LFu != null) {
        paramVarArgs.e(12, this.LFu);
      }
      paramVarArgs.aM(13, this.vkk);
      paramVarArgs.aM(14, this.uFa);
      paramVarArgs.e(15, 2, this.LFv);
      AppMethodBeat.o(169002);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1133;
      }
    }
    label1133:
    for (paramInt = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.r(2, this.hFK) + g.a.a.b.b.a.r(3, this.commentId) + g.a.a.b.b.a.bu(4, this.opType) + g.a.a.b.b.a.r(5, this.tsR) + g.a.a.b.b.a.bu(6, this.LFt);
      paramInt = i;
      if (this.username != null) {
        paramInt = i + g.a.a.b.b.a.f(7, this.username);
      }
      i = paramInt + g.a.a.b.b.a.bu(8, this.scene);
      paramInt = i;
      if (this.objectNonceId != null) {
        paramInt = i + g.a.a.b.b.a.f(9, this.objectNonceId);
      }
      i = paramInt;
      if (this.uli != null) {
        i = paramInt + g.a.a.a.nh(10, this.uli.computeSize());
      }
      paramInt = i;
      if (this.sessionBuffer != null) {
        paramInt = i + g.a.a.b.b.a.f(11, this.sessionBuffer);
      }
      i = paramInt;
      if (this.LFu != null) {
        i = paramInt + g.a.a.b.b.a.f(12, this.LFu);
      }
      paramInt = g.a.a.b.b.a.bu(13, this.vkk);
      int j = g.a.a.b.b.a.bu(14, this.uFa);
      int k = g.a.a.a.c(15, 2, this.LFv);
      AppMethodBeat.o(169002);
      return i + paramInt + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.LFv.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(169002);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        auo localauo = (auo)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(169002);
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
            localauo.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169002);
          return 0;
        case 2: 
          localauo.hFK = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(169002);
          return 0;
        case 3: 
          localauo.commentId = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(169002);
          return 0;
        case 4: 
          localauo.opType = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(169002);
          return 0;
        case 5: 
          localauo.tsR = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(169002);
          return 0;
        case 6: 
          localauo.LFt = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(169002);
          return 0;
        case 7: 
          localauo.username = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(169002);
          return 0;
        case 8: 
          localauo.scene = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(169002);
          return 0;
        case 9: 
          localauo.objectNonceId = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(169002);
          return 0;
        case 10: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aov();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aov)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localauo.uli = ((aov)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169002);
          return 0;
        case 11: 
          localauo.sessionBuffer = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(169002);
          return 0;
        case 12: 
          localauo.LFu = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(169002);
          return 0;
        case 13: 
          localauo.vkk = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(169002);
          return 0;
        case 14: 
          localauo.uFa = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(169002);
          return 0;
        }
        localauo.LFv.add(Integer.valueOf(((g.a.a.a.a)localObject1).UbS.zi()));
        AppMethodBeat.o(169002);
        return 0;
      }
      AppMethodBeat.o(169002);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.auo
 * JD-Core Version:    0.7.0.1
 */