package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;
import org.json.JSONObject;

public final class foc
  extends com.tencent.mm.bx.a
{
  public int Yjq;
  public int abNZ;
  public String abOa;
  public int abOb;
  public int abOc;
  public LinkedList<foh> abOd;
  public boolean abOe;
  public boolean hBY;
  
  public foc()
  {
    AppMethodBeat.i(153003);
    this.abOd = new LinkedList();
    AppMethodBeat.o(153003);
  }
  
  private JSONObject toJSON()
  {
    AppMethodBeat.i(258206);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      com.tencent.mm.bk.a.a(localJSONObject, "videoSecondType", Integer.valueOf(this.abNZ), false);
      com.tencent.mm.bk.a.a(localJSONObject, "originVideoId", this.abOa, false);
      com.tencent.mm.bk.a.a(localJSONObject, "insertPos", Integer.valueOf(this.Yjq), false);
      com.tencent.mm.bk.a.a(localJSONObject, "requestDuration", Integer.valueOf(this.abOb), false);
      com.tencent.mm.bk.a.a(localJSONObject, "requestPercent", Integer.valueOf(this.abOc), false);
      com.tencent.mm.bk.a.a(localJSONObject, "secondVideoInfoList", this.abOd, false);
      com.tencent.mm.bk.a.a(localJSONObject, "isRequest", Boolean.valueOf(this.abOe), false);
      com.tencent.mm.bk.a.a(localJSONObject, "isShow", Boolean.valueOf(this.hBY), false);
      label119:
      AppMethodBeat.o(258206);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      break label119;
    }
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153004);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.abNZ);
      if (this.abOa != null) {
        paramVarArgs.g(2, this.abOa);
      }
      paramVarArgs.bS(3, this.Yjq);
      paramVarArgs.bS(4, this.abOb);
      paramVarArgs.bS(5, this.abOc);
      paramVarArgs.e(6, 8, this.abOd);
      paramVarArgs.di(7, this.abOe);
      paramVarArgs.di(8, this.hBY);
      AppMethodBeat.o(153004);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.cJ(1, this.abNZ) + 0;
      paramInt = i;
      if (this.abOa != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.abOa);
      }
      i = i.a.a.b.b.a.cJ(3, this.Yjq);
      int j = i.a.a.b.b.a.cJ(4, this.abOb);
      int k = i.a.a.b.b.a.cJ(5, this.abOc);
      int m = i.a.a.a.c(6, 8, this.abOd);
      int n = i.a.a.b.b.a.ko(7);
      int i1 = i.a.a.b.b.a.ko(8);
      AppMethodBeat.o(153004);
      return paramInt + i + j + k + m + (n + 1) + (i1 + 1);
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.abOd.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(153004);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      foc localfoc = (foc)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(153004);
        return -1;
      case 1: 
        localfoc.abNZ = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(153004);
        return 0;
      case 2: 
        localfoc.abOa = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(153004);
        return 0;
      case 3: 
        localfoc.Yjq = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(153004);
        return 0;
      case 4: 
        localfoc.abOb = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(153004);
        return 0;
      case 5: 
        localfoc.abOc = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(153004);
        return 0;
      case 6: 
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          foh localfoh = new foh();
          if ((localObject != null) && (localObject.length > 0)) {
            localfoh.parseFrom((byte[])localObject);
          }
          localfoc.abOd.add(localfoh);
          paramInt += 1;
        }
        AppMethodBeat.o(153004);
        return 0;
      case 7: 
        localfoc.abOe = ((i.a.a.a.a)localObject).ajGk.aai();
        AppMethodBeat.o(153004);
        return 0;
      }
      localfoc.hBY = ((i.a.a.a.a)localObject).ajGk.aai();
      AppMethodBeat.o(153004);
      return 0;
    }
    AppMethodBeat.o(153004);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.foc
 * JD-Core Version:    0.7.0.1
 */