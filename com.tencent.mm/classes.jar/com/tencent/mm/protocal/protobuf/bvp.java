package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bvp
  extends com.tencent.mm.bx.a
{
  public String DUN;
  public long ZRl;
  public String ZRm;
  public FinderObject aadr;
  public bzc aads;
  public bvo aadt;
  public String hQR;
  public int replay_status;
  public String source;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258887);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.aadr != null)
      {
        paramVarArgs.qD(1, this.aadr.computeSize());
        this.aadr.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.replay_status);
      if (this.ZRm != null) {
        paramVarArgs.g(3, this.ZRm);
      }
      paramVarArgs.bv(4, this.ZRl);
      if (this.aads != null)
      {
        paramVarArgs.qD(5, this.aads.computeSize());
        this.aads.writeFields(paramVarArgs);
      }
      if (this.aadt != null)
      {
        paramVarArgs.qD(6, this.aadt.computeSize());
        this.aadt.writeFields(paramVarArgs);
      }
      if (this.source != null) {
        paramVarArgs.g(7, this.source);
      }
      if (this.hQR != null) {
        paramVarArgs.g(8, this.hQR);
      }
      if (this.DUN != null) {
        paramVarArgs.g(9, this.DUN);
      }
      AppMethodBeat.o(258887);
      return 0;
    }
    if (paramInt == 1) {
      if (this.aadr == null) {
        break label884;
      }
    }
    label884:
    for (paramInt = i.a.a.a.qC(1, this.aadr.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.replay_status);
      paramInt = i;
      if (this.ZRm != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.ZRm);
      }
      i = paramInt + i.a.a.b.b.a.q(4, this.ZRl);
      paramInt = i;
      if (this.aads != null) {
        paramInt = i + i.a.a.a.qC(5, this.aads.computeSize());
      }
      i = paramInt;
      if (this.aadt != null) {
        i = paramInt + i.a.a.a.qC(6, this.aadt.computeSize());
      }
      paramInt = i;
      if (this.source != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.source);
      }
      i = paramInt;
      if (this.hQR != null) {
        i = paramInt + i.a.a.b.b.a.h(8, this.hQR);
      }
      paramInt = i;
      if (this.DUN != null) {
        paramInt = i + i.a.a.b.b.a.h(9, this.DUN);
      }
      AppMethodBeat.o(258887);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(258887);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        bvp localbvp = (bvp)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(258887);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new FinderObject();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((FinderObject)localObject2).parseFrom((byte[])localObject1);
            }
            localbvp.aadr = ((FinderObject)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(258887);
          return 0;
        case 2: 
          localbvp.replay_status = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(258887);
          return 0;
        case 3: 
          localbvp.ZRm = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(258887);
          return 0;
        case 4: 
          localbvp.ZRl = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(258887);
          return 0;
        case 5: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bzc();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bzc)localObject2).parseFrom((byte[])localObject1);
            }
            localbvp.aads = ((bzc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(258887);
          return 0;
        case 6: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bvo();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bvo)localObject2).parseFrom((byte[])localObject1);
            }
            localbvp.aadt = ((bvo)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(258887);
          return 0;
        case 7: 
          localbvp.source = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(258887);
          return 0;
        case 8: 
          localbvp.hQR = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(258887);
          return 0;
        }
        localbvp.DUN = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(258887);
        return 0;
      }
      AppMethodBeat.o(258887);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bvp
 * JD-Core Version:    0.7.0.1
 */