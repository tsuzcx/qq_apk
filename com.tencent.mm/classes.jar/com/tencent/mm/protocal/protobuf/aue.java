package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class aue
  extends dop
{
  public aov LAI;
  public b LDx;
  public String LEQ;
  public String LER;
  public String finderUsername;
  public long hFK;
  public long liveId;
  public String object_nonce_id;
  public int scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209468);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.LAI != null)
      {
        paramVarArgs.ni(2, this.LAI.computeSize());
        this.LAI.writeFields(paramVarArgs);
      }
      paramVarArgs.bb(3, this.liveId);
      if (this.LDx != null) {
        paramVarArgs.c(4, this.LDx);
      }
      paramVarArgs.bb(5, this.hFK);
      if (this.finderUsername != null) {
        paramVarArgs.e(6, this.finderUsername);
      }
      paramVarArgs.aM(7, this.scene);
      if (this.LEQ != null) {
        paramVarArgs.e(8, this.LEQ);
      }
      if (this.object_nonce_id != null) {
        paramVarArgs.e(9, this.object_nonce_id);
      }
      if (this.LER != null) {
        paramVarArgs.e(10, this.LER);
      }
      AppMethodBeat.o(209468);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label906;
      }
    }
    label906:
    for (paramInt = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.LAI != null) {
        i = paramInt + g.a.a.a.nh(2, this.LAI.computeSize());
      }
      i += g.a.a.b.b.a.r(3, this.liveId);
      paramInt = i;
      if (this.LDx != null) {
        paramInt = i + g.a.a.b.b.a.b(4, this.LDx);
      }
      i = paramInt + g.a.a.b.b.a.r(5, this.hFK);
      paramInt = i;
      if (this.finderUsername != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.finderUsername);
      }
      i = paramInt + g.a.a.b.b.a.bu(7, this.scene);
      paramInt = i;
      if (this.LEQ != null) {
        paramInt = i + g.a.a.b.b.a.f(8, this.LEQ);
      }
      i = paramInt;
      if (this.object_nonce_id != null) {
        i = paramInt + g.a.a.b.b.a.f(9, this.object_nonce_id);
      }
      paramInt = i;
      if (this.LER != null) {
        paramInt = i + g.a.a.b.b.a.f(10, this.LER);
      }
      AppMethodBeat.o(209468);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(209468);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        aue localaue = (aue)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(209468);
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
            localaue.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(209468);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aov();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aov)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localaue.LAI = ((aov)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(209468);
          return 0;
        case 3: 
          localaue.liveId = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(209468);
          return 0;
        case 4: 
          localaue.LDx = ((g.a.a.a.a)localObject1).UbS.hPo();
          AppMethodBeat.o(209468);
          return 0;
        case 5: 
          localaue.hFK = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(209468);
          return 0;
        case 6: 
          localaue.finderUsername = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(209468);
          return 0;
        case 7: 
          localaue.scene = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(209468);
          return 0;
        case 8: 
          localaue.LEQ = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(209468);
          return 0;
        case 9: 
          localaue.object_nonce_id = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(209468);
          return 0;
        }
        localaue.LER = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(209468);
        return 0;
      }
      AppMethodBeat.o(209468);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aue
 * JD-Core Version:    0.7.0.1
 */