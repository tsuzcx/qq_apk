package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;
import org.json.JSONObject;

public final class fnu
  extends com.tencent.mm.bx.a
{
  public int aary;
  public long abNM;
  public int abNN;
  public int abqR;
  public LinkedList<String> abqT;
  public String nUB;
  
  public fnu()
  {
    AppMethodBeat.i(152998);
    this.abqT = new LinkedList();
    AppMethodBeat.o(152998);
  }
  
  private JSONObject toJSON()
  {
    AppMethodBeat.i(258405);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      com.tencent.mm.bk.a.a(localJSONObject, "Content", this.nUB, false);
      com.tencent.mm.bk.a.a(localJSONObject, "SaveTs", Long.valueOf(this.abNM), false);
      com.tencent.mm.bk.a.a(localJSONObject, "DirectShowTs", Integer.valueOf(this.abqR), false);
      com.tencent.mm.bk.a.a(localJSONObject, "ShowAndRefreshTs", Integer.valueOf(this.abNN), false);
      com.tencent.mm.bk.a.a(localJSONObject, "Category", Integer.valueOf(this.aary), false);
      com.tencent.mm.bk.a.a(localJSONObject, "DocidList", this.abqT, false);
      label91:
      AppMethodBeat.o(258405);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      break label91;
    }
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152999);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.nUB != null) {
        paramVarArgs.g(1, this.nUB);
      }
      paramVarArgs.bv(2, this.abNM);
      paramVarArgs.bS(3, this.abqR);
      paramVarArgs.bS(4, this.abNN);
      paramVarArgs.bS(5, this.aary);
      paramVarArgs.e(6, 1, this.abqT);
      AppMethodBeat.o(152999);
      return 0;
    }
    if (paramInt == 1) {
      if (this.nUB == null) {
        break label458;
      }
    }
    label458:
    for (paramInt = i.a.a.b.b.a.h(1, this.nUB) + 0;; paramInt = 0)
    {
      int i = i.a.a.b.b.a.q(2, this.abNM);
      int j = i.a.a.b.b.a.cJ(3, this.abqR);
      int k = i.a.a.b.b.a.cJ(4, this.abNN);
      int m = i.a.a.b.b.a.cJ(5, this.aary);
      int n = i.a.a.a.c(6, 1, this.abqT);
      AppMethodBeat.o(152999);
      return paramInt + i + j + k + m + n;
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
        AppMethodBeat.o(152999);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        fnu localfnu = (fnu)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(152999);
          return -1;
        case 1: 
          localfnu.nUB = locala.ajGk.readString();
          AppMethodBeat.o(152999);
          return 0;
        case 2: 
          localfnu.abNM = locala.ajGk.aaw();
          AppMethodBeat.o(152999);
          return 0;
        case 3: 
          localfnu.abqR = locala.ajGk.aar();
          AppMethodBeat.o(152999);
          return 0;
        case 4: 
          localfnu.abNN = locala.ajGk.aar();
          AppMethodBeat.o(152999);
          return 0;
        case 5: 
          localfnu.aary = locala.ajGk.aar();
          AppMethodBeat.o(152999);
          return 0;
        }
        localfnu.abqT.add(locala.ajGk.readString());
        AppMethodBeat.o(152999);
        return 0;
      }
      AppMethodBeat.o(152999);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fnu
 * JD-Core Version:    0.7.0.1
 */