package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;
import org.json.JSONObject;

public final class ghu
  extends esc
{
  public int YYs;
  public String aayd;
  public int acek;
  public emr acel;
  public emp acem;
  public int acen;
  
  private JSONObject toJSON()
  {
    AppMethodBeat.i(258819);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      com.tencent.mm.bk.a.a(localJSONObject, "BaseResponse", this.BaseResponse, false);
      com.tencent.mm.bk.a.a(localJSONObject, "UpdateCode", Integer.valueOf(this.acek), false);
      com.tencent.mm.bk.a.a(localJSONObject, "Offset", Integer.valueOf(this.YYs), false);
      com.tencent.mm.bk.a.a(localJSONObject, "Json", this.aayd, false);
      com.tencent.mm.bk.a.a(localJSONObject, "Plugin", this.acel, false);
      com.tencent.mm.bk.a.a(localJSONObject, "ClientCache", this.acem, false);
      com.tencent.mm.bk.a.a(localJSONObject, "RedDotTimeStamp", Integer.valueOf(this.acen), false);
      label99:
      AppMethodBeat.o(258819);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      break label99;
    }
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117949);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.acek);
      paramVarArgs.bS(3, this.YYs);
      if (this.aayd != null) {
        paramVarArgs.g(4, this.aayd);
      }
      if (this.acel != null)
      {
        paramVarArgs.qD(5, this.acel.computeSize());
        this.acel.writeFields(paramVarArgs);
      }
      if (this.acem != null)
      {
        paramVarArgs.qD(6, this.acem.computeSize());
        this.acem.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(7, this.acen);
      AppMethodBeat.o(117949);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label744;
      }
    }
    label744:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.acek) + i.a.a.b.b.a.cJ(3, this.YYs);
      paramInt = i;
      if (this.aayd != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.aayd);
      }
      i = paramInt;
      if (this.acel != null) {
        i = paramInt + i.a.a.a.qC(5, this.acel.computeSize());
      }
      paramInt = i;
      if (this.acem != null) {
        paramInt = i + i.a.a.a.qC(6, this.acem.computeSize());
      }
      i = i.a.a.b.b.a.cJ(7, this.acen);
      AppMethodBeat.o(117949);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(117949);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        ghu localghu = (ghu)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(117949);
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
            localghu.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(117949);
          return 0;
        case 2: 
          localghu.acek = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(117949);
          return 0;
        case 3: 
          localghu.YYs = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(117949);
          return 0;
        case 4: 
          localghu.aayd = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(117949);
          return 0;
        case 5: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new emr();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((emr)localObject2).parseFrom((byte[])localObject1);
            }
            localghu.acel = ((emr)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(117949);
          return 0;
        case 6: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new emp();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((emp)localObject2).parseFrom((byte[])localObject1);
            }
            localghu.acem = ((emp)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(117949);
          return 0;
        }
        localghu.acen = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(117949);
        return 0;
      }
      AppMethodBeat.o(117949);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ghu
 * JD-Core Version:    0.7.0.1
 */