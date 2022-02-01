package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;
import org.json.JSONObject;

public final class te
  extends com.tencent.mm.bx.a
{
  public LinkedList<qx> YYH;
  public LinkedList<gfj> YYI;
  public LinkedList<akt> YYJ;
  public LinkedList<gja> YYK;
  public eqj YYL;
  public b YYM;
  public LinkedList<eax> YYN;
  public int vhJ;
  
  public te()
  {
    AppMethodBeat.i(117848);
    this.YYH = new LinkedList();
    this.YYI = new LinkedList();
    this.YYJ = new LinkedList();
    this.YYK = new LinkedList();
    this.YYN = new LinkedList();
    AppMethodBeat.o(117848);
  }
  
  private JSONObject toJSON()
  {
    AppMethodBeat.i(259533);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      com.tencent.mm.bk.a.a(localJSONObject, "Type", Integer.valueOf(this.vhJ), false);
      com.tencent.mm.bk.a.a(localJSONObject, "BizResults", this.YYH, false);
      com.tencent.mm.bk.a.a(localJSONObject, "WeappResults", this.YYI, false);
      com.tencent.mm.bk.a.a(localJSONObject, "DocResults", this.YYJ, false);
      com.tencent.mm.bk.a.a(localJSONObject, "WidgetResults", this.YYK, false);
      com.tencent.mm.bk.a.a(localJSONObject, "ReportInfo", this.YYL, false);
      com.tencent.mm.bk.a.a(localJSONObject, "DebugInfo", this.YYM, false);
      com.tencent.mm.bk.a.a(localJSONObject, "PardusResults", this.YYN, false);
      label104:
      AppMethodBeat.o(259533);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      break label104;
    }
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117849);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.vhJ);
      paramVarArgs.e(2, 8, this.YYH);
      paramVarArgs.e(3, 8, this.YYI);
      paramVarArgs.e(4, 8, this.YYJ);
      paramVarArgs.e(5, 8, this.YYK);
      if (this.YYL != null)
      {
        paramVarArgs.qD(6, this.YYL.computeSize());
        this.YYL.writeFields(paramVarArgs);
      }
      if (this.YYM != null) {
        paramVarArgs.d(7, this.YYM);
      }
      paramVarArgs.e(8, 8, this.YYN);
      AppMethodBeat.o(117849);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.cJ(1, this.vhJ) + 0 + i.a.a.a.c(2, 8, this.YYH) + i.a.a.a.c(3, 8, this.YYI) + i.a.a.a.c(4, 8, this.YYJ) + i.a.a.a.c(5, 8, this.YYK);
      paramInt = i;
      if (this.YYL != null) {
        paramInt = i + i.a.a.a.qC(6, this.YYL.computeSize());
      }
      i = paramInt;
      if (this.YYM != null) {
        i = paramInt + i.a.a.b.b.a.c(7, this.YYM);
      }
      paramInt = i.a.a.a.c(8, 8, this.YYN);
      AppMethodBeat.o(117849);
      return i + paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.YYH.clear();
      this.YYI.clear();
      this.YYJ.clear();
      this.YYK.clear();
      this.YYN.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(117849);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
      te localte = (te)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(117849);
        return -1;
      case 1: 
        localte.vhJ = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(117849);
        return 0;
      case 2: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new qx();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((qx)localObject2).parseFrom((byte[])localObject1);
          }
          localte.YYH.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(117849);
        return 0;
      case 3: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new gfj();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((gfj)localObject2).parseFrom((byte[])localObject1);
          }
          localte.YYI.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(117849);
        return 0;
      case 4: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new akt();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((akt)localObject2).parseFrom((byte[])localObject1);
          }
          localte.YYJ.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(117849);
        return 0;
      case 5: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new gja();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((gja)localObject2).parseFrom((byte[])localObject1);
          }
          localte.YYK.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(117849);
        return 0;
      case 6: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new eqj();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((eqj)localObject2).parseFrom((byte[])localObject1);
          }
          localte.YYL = ((eqj)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(117849);
        return 0;
      case 7: 
        localte.YYM = ((i.a.a.a.a)localObject1).ajGk.kFX();
        AppMethodBeat.o(117849);
        return 0;
      }
      paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject1 = (byte[])paramVarArgs.get(paramInt);
        localObject2 = new eax();
        if ((localObject1 != null) && (localObject1.length > 0)) {
          ((eax)localObject2).parseFrom((byte[])localObject1);
        }
        localte.YYN.add(localObject2);
        paramInt += 1;
      }
      AppMethodBeat.o(117849);
      return 0;
    }
    AppMethodBeat.o(117849);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.te
 * JD-Core Version:    0.7.0.1
 */