package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;
import org.json.JSONObject;

public final class tf
  extends com.tencent.mm.bx.a
{
  public sx YYO;
  public sw YYP;
  public long YYQ;
  public td YYR;
  public th YYS;
  public tc YYT;
  public int vhJ;
  
  private JSONObject toJSON()
  {
    AppMethodBeat.i(259464);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      com.tencent.mm.bk.a.a(localJSONObject, "Type", Integer.valueOf(this.vhJ), false);
      com.tencent.mm.bk.a.a(localJSONObject, "ContactItem", this.YYO, false);
      com.tencent.mm.bk.a.a(localJSONObject, "CommonItem", this.YYP, false);
      com.tencent.mm.bk.a.a(localJSONObject, "DocID", Long.valueOf(this.YYQ), false);
      com.tencent.mm.bk.a.a(localJSONObject, "ProductItem", this.YYR, false);
      com.tencent.mm.bk.a.a(localJSONObject, "SnsItem", this.YYS, false);
      com.tencent.mm.bk.a.a(localJSONObject, "POIItem", this.YYT, false);
      label96:
      AppMethodBeat.o(259464);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      break label96;
    }
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117850);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.vhJ);
      if (this.YYO != null)
      {
        paramVarArgs.qD(2, this.YYO.computeSize());
        this.YYO.writeFields(paramVarArgs);
      }
      if (this.YYP != null)
      {
        paramVarArgs.qD(3, this.YYP.computeSize());
        this.YYP.writeFields(paramVarArgs);
      }
      paramVarArgs.bv(4, this.YYQ);
      if (this.YYR != null)
      {
        paramVarArgs.qD(5, this.YYR.computeSize());
        this.YYR.writeFields(paramVarArgs);
      }
      if (this.YYS != null)
      {
        paramVarArgs.qD(6, this.YYS.computeSize());
        this.YYS.writeFields(paramVarArgs);
      }
      if (this.YYT != null)
      {
        paramVarArgs.qD(7, this.YYT.computeSize());
        this.YYT.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(117850);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.cJ(1, this.vhJ) + 0;
      paramInt = i;
      if (this.YYO != null) {
        paramInt = i + i.a.a.a.qC(2, this.YYO.computeSize());
      }
      i = paramInt;
      if (this.YYP != null) {
        i = paramInt + i.a.a.a.qC(3, this.YYP.computeSize());
      }
      i += i.a.a.b.b.a.q(4, this.YYQ);
      paramInt = i;
      if (this.YYR != null) {
        paramInt = i + i.a.a.a.qC(5, this.YYR.computeSize());
      }
      i = paramInt;
      if (this.YYS != null) {
        i = paramInt + i.a.a.a.qC(6, this.YYS.computeSize());
      }
      paramInt = i;
      if (this.YYT != null) {
        paramInt = i + i.a.a.a.qC(7, this.YYT.computeSize());
      }
      AppMethodBeat.o(117850);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(117850);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
      tf localtf = (tf)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(117850);
        return -1;
      case 1: 
        localtf.vhJ = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(117850);
        return 0;
      case 2: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new sx();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((sx)localObject2).parseFrom((byte[])localObject1);
          }
          localtf.YYO = ((sx)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(117850);
        return 0;
      case 3: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new sw();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((sw)localObject2).parseFrom((byte[])localObject1);
          }
          localtf.YYP = ((sw)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(117850);
        return 0;
      case 4: 
        localtf.YYQ = ((i.a.a.a.a)localObject1).ajGk.aaw();
        AppMethodBeat.o(117850);
        return 0;
      case 5: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new td();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((td)localObject2).parseFrom((byte[])localObject1);
          }
          localtf.YYR = ((td)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(117850);
        return 0;
      case 6: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new th();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((th)localObject2).parseFrom((byte[])localObject1);
          }
          localtf.YYS = ((th)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(117850);
        return 0;
      }
      paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject1 = (byte[])paramVarArgs.get(paramInt);
        localObject2 = new tc();
        if ((localObject1 != null) && (localObject1.length > 0)) {
          ((tc)localObject2).parseFrom((byte[])localObject1);
        }
        localtf.YYT = ((tc)localObject2);
        paramInt += 1;
      }
      AppMethodBeat.o(117850);
      return 0;
    }
    AppMethodBeat.o(117850);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.tf
 * JD-Core Version:    0.7.0.1
 */