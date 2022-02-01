package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class asx
  extends com.tencent.mm.bx.a
{
  public int YIE;
  public String ZCY;
  public long ZCZ;
  public String ZDa;
  public LinkedList<asv> ZDb;
  public cbn ZDc;
  public int vhE;
  
  public asx()
  {
    AppMethodBeat.i(110849);
    this.ZDb = new LinkedList();
    AppMethodBeat.o(110849);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(110850);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.ZCY == null)
      {
        paramVarArgs = new b("Not all required fields were included: Rid");
        AppMethodBeat.o(110850);
        throw paramVarArgs;
      }
      if (this.ZDa == null)
      {
        paramVarArgs = new b("Not all required fields were included: MimeType");
        AppMethodBeat.o(110850);
        throw paramVarArgs;
      }
      if (this.ZCY != null) {
        paramVarArgs.g(1, this.ZCY);
      }
      paramVarArgs.bv(2, this.ZCZ);
      paramVarArgs.bS(3, this.vhE);
      if (this.ZDa != null) {
        paramVarArgs.g(4, this.ZDa);
      }
      paramVarArgs.e(5, 8, this.ZDb);
      if (this.ZDc != null)
      {
        paramVarArgs.qD(6, this.ZDc.computeSize());
        this.ZDc.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(7, this.YIE);
      AppMethodBeat.o(110850);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ZCY == null) {
        break label754;
      }
    }
    label754:
    for (paramInt = i.a.a.b.b.a.h(1, this.ZCY) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.q(2, this.ZCZ) + i.a.a.b.b.a.cJ(3, this.vhE);
      paramInt = i;
      if (this.ZDa != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.ZDa);
      }
      i = paramInt + i.a.a.a.c(5, 8, this.ZDb);
      paramInt = i;
      if (this.ZDc != null) {
        paramInt = i + i.a.a.a.qC(6, this.ZDc.computeSize());
      }
      i = i.a.a.b.b.a.cJ(7, this.YIE);
      AppMethodBeat.o(110850);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.ZDb.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.ZCY == null)
        {
          paramVarArgs = new b("Not all required fields were included: Rid");
          AppMethodBeat.o(110850);
          throw paramVarArgs;
        }
        if (this.ZDa == null)
        {
          paramVarArgs = new b("Not all required fields were included: MimeType");
          AppMethodBeat.o(110850);
          throw paramVarArgs;
        }
        AppMethodBeat.o(110850);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        asx localasx = (asx)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(110850);
          return -1;
        case 1: 
          localasx.ZCY = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(110850);
          return 0;
        case 2: 
          localasx.ZCZ = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(110850);
          return 0;
        case 3: 
          localasx.vhE = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(110850);
          return 0;
        case 4: 
          localasx.ZDa = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(110850);
          return 0;
        case 5: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new asv();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((asv)localObject2).parseFrom((byte[])localObject1);
            }
            localasx.ZDb.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(110850);
          return 0;
        case 6: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new cbn();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((cbn)localObject2).parseFrom((byte[])localObject1);
            }
            localasx.ZDc = ((cbn)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(110850);
          return 0;
        }
        localasx.YIE = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(110850);
        return 0;
      }
      AppMethodBeat.o(110850);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.asx
 * JD-Core Version:    0.7.0.1
 */