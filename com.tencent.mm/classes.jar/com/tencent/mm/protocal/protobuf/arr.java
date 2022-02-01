package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class arr
  extends dop
{
  public long LDa;
  public int LDb;
  public String LDc;
  public int LDd;
  public int direction;
  public String finderUsername;
  public long hFK;
  public b lastBuffer;
  public b likeBuffer;
  public String objectNonceId;
  public int scene;
  public long tuf;
  public long tuj;
  public int tum;
  public aov uli;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(168973);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.bb(2, this.hFK);
      paramVarArgs.bb(3, this.LDa);
      paramVarArgs.aM(4, this.LDb);
      if (this.lastBuffer != null) {
        paramVarArgs.c(5, this.lastBuffer);
      }
      paramVarArgs.bb(6, this.tuf);
      if (this.finderUsername != null) {
        paramVarArgs.e(7, this.finderUsername);
      }
      paramVarArgs.bb(8, this.tuj);
      paramVarArgs.aM(9, this.scene);
      paramVarArgs.aM(10, this.direction);
      if (this.LDc != null) {
        paramVarArgs.e(11, this.LDc);
      }
      if (this.objectNonceId != null) {
        paramVarArgs.e(12, this.objectNonceId);
      }
      if (this.uli != null)
      {
        paramVarArgs.ni(13, this.uli.computeSize());
        this.uli.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(14, this.LDd);
      paramVarArgs.aM(15, this.tum);
      if (this.likeBuffer != null) {
        paramVarArgs.c(16, this.likeBuffer);
      }
      AppMethodBeat.o(168973);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1174;
      }
    }
    label1174:
    for (paramInt = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.r(2, this.hFK) + g.a.a.b.b.a.r(3, this.LDa) + g.a.a.b.b.a.bu(4, this.LDb);
      paramInt = i;
      if (this.lastBuffer != null) {
        paramInt = i + g.a.a.b.b.a.b(5, this.lastBuffer);
      }
      i = paramInt + g.a.a.b.b.a.r(6, this.tuf);
      paramInt = i;
      if (this.finderUsername != null) {
        paramInt = i + g.a.a.b.b.a.f(7, this.finderUsername);
      }
      i = paramInt + g.a.a.b.b.a.r(8, this.tuj) + g.a.a.b.b.a.bu(9, this.scene) + g.a.a.b.b.a.bu(10, this.direction);
      paramInt = i;
      if (this.LDc != null) {
        paramInt = i + g.a.a.b.b.a.f(11, this.LDc);
      }
      i = paramInt;
      if (this.objectNonceId != null) {
        i = paramInt + g.a.a.b.b.a.f(12, this.objectNonceId);
      }
      paramInt = i;
      if (this.uli != null) {
        paramInt = i + g.a.a.a.nh(13, this.uli.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bu(14, this.LDd) + g.a.a.b.b.a.bu(15, this.tum);
      paramInt = i;
      if (this.likeBuffer != null) {
        paramInt = i + g.a.a.b.b.a.b(16, this.likeBuffer);
      }
      AppMethodBeat.o(168973);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(168973);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        arr localarr = (arr)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(168973);
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
            localarr.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(168973);
          return 0;
        case 2: 
          localarr.hFK = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(168973);
          return 0;
        case 3: 
          localarr.LDa = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(168973);
          return 0;
        case 4: 
          localarr.LDb = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(168973);
          return 0;
        case 5: 
          localarr.lastBuffer = ((g.a.a.a.a)localObject1).UbS.hPo();
          AppMethodBeat.o(168973);
          return 0;
        case 6: 
          localarr.tuf = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(168973);
          return 0;
        case 7: 
          localarr.finderUsername = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(168973);
          return 0;
        case 8: 
          localarr.tuj = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(168973);
          return 0;
        case 9: 
          localarr.scene = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(168973);
          return 0;
        case 10: 
          localarr.direction = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(168973);
          return 0;
        case 11: 
          localarr.LDc = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(168973);
          return 0;
        case 12: 
          localarr.objectNonceId = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(168973);
          return 0;
        case 13: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aov();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aov)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localarr.uli = ((aov)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(168973);
          return 0;
        case 14: 
          localarr.LDd = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(168973);
          return 0;
        case 15: 
          localarr.tum = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(168973);
          return 0;
        }
        localarr.likeBuffer = ((g.a.a.a.a)localObject1).UbS.hPo();
        AppMethodBeat.o(168973);
        return 0;
      }
      AppMethodBeat.o(168973);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.arr
 * JD-Core Version:    0.7.0.1
 */