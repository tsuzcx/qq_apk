package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bsm
  extends erp
{
  public atz CJv;
  public FinderObjectDesc aaan;
  public int aaao;
  public String aaap;
  public atr aaaq;
  public int aaar;
  public long object_id;
  public int scene;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259869);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.CJv != null)
      {
        paramVarArgs.qD(2, this.CJv.computeSize());
        this.CJv.writeFields(paramVarArgs);
      }
      if (this.username != null) {
        paramVarArgs.g(3, this.username);
      }
      if (this.aaan != null)
      {
        paramVarArgs.qD(4, this.aaan.computeSize());
        this.aaan.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(5, this.aaao);
      if (this.aaap != null) {
        paramVarArgs.g(6, this.aaap);
      }
      paramVarArgs.bS(7, this.scene);
      paramVarArgs.bv(8, this.object_id);
      if (this.aaaq != null)
      {
        paramVarArgs.qD(9, this.aaaq.computeSize());
        this.aaaq.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(10, this.aaar);
      AppMethodBeat.o(259869);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label986;
      }
    }
    label986:
    for (int i = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.CJv != null) {
        paramInt = i + i.a.a.a.qC(2, this.CJv.computeSize());
      }
      i = paramInt;
      if (this.username != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.username);
      }
      paramInt = i;
      if (this.aaan != null) {
        paramInt = i + i.a.a.a.qC(4, this.aaan.computeSize());
      }
      i = paramInt + i.a.a.b.b.a.cJ(5, this.aaao);
      paramInt = i;
      if (this.aaap != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.aaap);
      }
      i = paramInt + i.a.a.b.b.a.cJ(7, this.scene) + i.a.a.b.b.a.q(8, this.object_id);
      paramInt = i;
      if (this.aaaq != null) {
        paramInt = i + i.a.a.a.qC(9, this.aaaq.computeSize());
      }
      i = i.a.a.b.b.a.cJ(10, this.aaar);
      AppMethodBeat.o(259869);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(259869);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        bsm localbsm = (bsm)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(259869);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new kc();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((kc)localObject2).parseFrom((byte[])localObject1);
            }
            localbsm.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259869);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new atz();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((atz)localObject2).parseFrom((byte[])localObject1);
            }
            localbsm.CJv = ((atz)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259869);
          return 0;
        case 3: 
          localbsm.username = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(259869);
          return 0;
        case 4: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new FinderObjectDesc();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((FinderObjectDesc)localObject2).parseFrom((byte[])localObject1);
            }
            localbsm.aaan = ((FinderObjectDesc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259869);
          return 0;
        case 5: 
          localbsm.aaao = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(259869);
          return 0;
        case 6: 
          localbsm.aaap = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(259869);
          return 0;
        case 7: 
          localbsm.scene = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(259869);
          return 0;
        case 8: 
          localbsm.object_id = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(259869);
          return 0;
        case 9: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new atr();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((atr)localObject2).parseFrom((byte[])localObject1);
            }
            localbsm.aaaq = ((atr)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259869);
          return 0;
        }
        localbsm.aaar = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(259869);
        return 0;
      }
      AppMethodBeat.o(259869);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bsm
 * JD-Core Version:    0.7.0.1
 */