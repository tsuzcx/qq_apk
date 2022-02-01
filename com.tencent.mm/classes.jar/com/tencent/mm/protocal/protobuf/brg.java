package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class brg
  extends com.tencent.mm.bx.a
{
  public awx ZHN;
  public String ZZl;
  public int ZZm;
  public long ZZn;
  public String eventName;
  public long ocD;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257455);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bv(1, this.ocD);
      if (this.eventName != null) {
        paramVarArgs.g(2, this.eventName);
      }
      if (this.ZZl != null) {
        paramVarArgs.g(3, this.ZZl);
      }
      paramVarArgs.bS(4, this.ZZm);
      if (this.ZHN != null)
      {
        paramVarArgs.qD(5, this.ZHN.computeSize());
        this.ZHN.writeFields(paramVarArgs);
      }
      paramVarArgs.bv(6, this.ZZn);
      AppMethodBeat.o(257455);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.q(1, this.ocD) + 0;
      paramInt = i;
      if (this.eventName != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.eventName);
      }
      i = paramInt;
      if (this.ZZl != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.ZZl);
      }
      i += i.a.a.b.b.a.cJ(4, this.ZZm);
      paramInt = i;
      if (this.ZHN != null) {
        paramInt = i + i.a.a.a.qC(5, this.ZHN.computeSize());
      }
      i = i.a.a.b.b.a.q(6, this.ZZn);
      AppMethodBeat.o(257455);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(257455);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      brg localbrg = (brg)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(257455);
        return -1;
      case 1: 
        localbrg.ocD = ((i.a.a.a.a)localObject).ajGk.aaw();
        AppMethodBeat.o(257455);
        return 0;
      case 2: 
        localbrg.eventName = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(257455);
        return 0;
      case 3: 
        localbrg.ZZl = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(257455);
        return 0;
      case 4: 
        localbrg.ZZm = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(257455);
        return 0;
      case 5: 
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          awx localawx = new awx();
          if ((localObject != null) && (localObject.length > 0)) {
            localawx.parseFrom((byte[])localObject);
          }
          localbrg.ZHN = localawx;
          paramInt += 1;
        }
        AppMethodBeat.o(257455);
        return 0;
      }
      localbrg.ZZn = ((i.a.a.a.a)localObject).ajGk.aaw();
      AppMethodBeat.o(257455);
      return 0;
    }
    AppMethodBeat.o(257455);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.brg
 * JD-Core Version:    0.7.0.1
 */