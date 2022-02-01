package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;
import org.json.JSONObject;

public final class chp
  extends esc
{
  public LinkedList<rt> YIB;
  public int YJw;
  public int YYp;
  public int YYs;
  public long aanC;
  public int aaqp;
  
  public chp()
  {
    AppMethodBeat.i(117869);
    this.YIB = new LinkedList();
    AppMethodBeat.o(117869);
  }
  
  private JSONObject toJSON()
  {
    AppMethodBeat.i(259033);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      com.tencent.mm.bk.a.a(localJSONObject, "BaseResponse", this.BaseResponse, false);
      com.tencent.mm.bk.a.a(localJSONObject, "Items", this.YIB, false);
      com.tencent.mm.bk.a.a(localJSONObject, "ContinueFlag", Integer.valueOf(this.YYp), false);
      com.tencent.mm.bk.a.a(localJSONObject, "Total", Integer.valueOf(this.aaqp), false);
      com.tencent.mm.bk.a.a(localJSONObject, "UpdateFlag", Integer.valueOf(this.YJw), false);
      com.tencent.mm.bk.a.a(localJSONObject, "Version", Long.valueOf(this.aanC), false);
      com.tencent.mm.bk.a.a(localJSONObject, "Offset", Integer.valueOf(this.YYs), false);
      label105:
      AppMethodBeat.o(259033);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      break label105;
    }
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117870);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.YIB);
      paramVarArgs.bS(3, this.YYp);
      paramVarArgs.bS(4, this.aaqp);
      paramVarArgs.bS(5, this.YJw);
      paramVarArgs.bv(6, this.aanC);
      paramVarArgs.bS(7, this.YYs);
      AppMethodBeat.o(117870);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label638;
      }
    }
    label638:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = i.a.a.a.c(2, 8, this.YIB);
      int j = i.a.a.b.b.a.cJ(3, this.YYp);
      int k = i.a.a.b.b.a.cJ(4, this.aaqp);
      int m = i.a.a.b.b.a.cJ(5, this.YJw);
      int n = i.a.a.b.b.a.q(6, this.aanC);
      int i1 = i.a.a.b.b.a.cJ(7, this.YYs);
      AppMethodBeat.o(117870);
      return paramInt + i + j + k + m + n + i1;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.YIB.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(117870);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        chp localchp = (chp)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(117870);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new kd();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((kd)localObject2).parseFrom((byte[])localObject1);
            }
            localchp.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(117870);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new rt();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((rt)localObject2).parseFrom((byte[])localObject1);
            }
            localchp.YIB.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(117870);
          return 0;
        case 3: 
          localchp.YYp = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(117870);
          return 0;
        case 4: 
          localchp.aaqp = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(117870);
          return 0;
        case 5: 
          localchp.YJw = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(117870);
          return 0;
        case 6: 
          localchp.aanC = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(117870);
          return 0;
        }
        localchp.YYs = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(117870);
        return 0;
      }
      AppMethodBeat.o(117870);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.chp
 * JD-Core Version:    0.7.0.1
 */