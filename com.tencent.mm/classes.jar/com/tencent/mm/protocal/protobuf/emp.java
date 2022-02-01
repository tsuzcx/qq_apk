package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;
import org.json.JSONObject;

public final class emp
  extends com.tencent.mm.bx.a
{
  public int aary;
  public int abqR;
  public int abqS;
  public LinkedList<String> abqT;
  public int abqU;
  
  public emp()
  {
    AppMethodBeat.i(117893);
    this.abqT = new LinkedList();
    AppMethodBeat.o(117893);
  }
  
  private JSONObject toJSON()
  {
    AppMethodBeat.i(260179);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      com.tencent.mm.bk.a.a(localJSONObject, "DirectShowTs", Integer.valueOf(this.abqR), false);
      com.tencent.mm.bk.a.a(localJSONObject, "ShowAndRefleshTs", Integer.valueOf(this.abqS), false);
      com.tencent.mm.bk.a.a(localJSONObject, "Category", Integer.valueOf(this.aary), false);
      com.tencent.mm.bk.a.a(localJSONObject, "DocidList", this.abqT, false);
      com.tencent.mm.bk.a.a(localJSONObject, "NeedCache", Integer.valueOf(this.abqU), false);
      label80:
      AppMethodBeat.o(260179);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      break label80;
    }
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117894);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.abqR);
      paramVarArgs.bS(2, this.abqS);
      paramVarArgs.bS(3, this.aary);
      paramVarArgs.e(4, 1, this.abqT);
      paramVarArgs.bS(5, this.abqU);
      AppMethodBeat.o(117894);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = i.a.a.b.b.a.cJ(1, this.abqR);
      int i = i.a.a.b.b.a.cJ(2, this.abqS);
      int j = i.a.a.b.b.a.cJ(3, this.aary);
      int k = i.a.a.a.c(4, 1, this.abqT);
      int m = i.a.a.b.b.a.cJ(5, this.abqU);
      AppMethodBeat.o(117894);
      return paramInt + 0 + i + j + k + m;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.abqT.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(117894);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      emp localemp = (emp)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(117894);
        return -1;
      case 1: 
        localemp.abqR = locala.ajGk.aar();
        AppMethodBeat.o(117894);
        return 0;
      case 2: 
        localemp.abqS = locala.ajGk.aar();
        AppMethodBeat.o(117894);
        return 0;
      case 3: 
        localemp.aary = locala.ajGk.aar();
        AppMethodBeat.o(117894);
        return 0;
      case 4: 
        localemp.abqT.add(locala.ajGk.readString());
        AppMethodBeat.o(117894);
        return 0;
      }
      localemp.abqU = locala.ajGk.aar();
      AppMethodBeat.o(117894);
      return 0;
    }
    AppMethodBeat.o(117894);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.emp
 * JD-Core Version:    0.7.0.1
 */