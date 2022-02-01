package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;
import org.json.JSONObject;

public final class fof
  extends com.tencent.mm.bx.a
{
  public String abOt;
  public String abOu;
  public LinkedList<ass> abOv;
  
  public fof()
  {
    AppMethodBeat.i(153008);
    this.abOv = new LinkedList();
    AppMethodBeat.o(153008);
  }
  
  private JSONObject toJSON()
  {
    AppMethodBeat.i(258233);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      com.tencent.mm.bk.a.a(localJSONObject, "feedbackDetailWording", this.abOt, false);
      com.tencent.mm.bk.a.a(localJSONObject, "feedbackDetailUrl", this.abOu, false);
      com.tencent.mm.bk.a.a(localJSONObject, "feedbackItemList", this.abOv, false);
      label46:
      AppMethodBeat.o(258233);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      break label46;
    }
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153009);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.abOt != null) {
        paramVarArgs.g(1, this.abOt);
      }
      if (this.abOu != null) {
        paramVarArgs.g(2, this.abOu);
      }
      paramVarArgs.e(3, 8, this.abOv);
      AppMethodBeat.o(153009);
      return 0;
    }
    if (paramInt == 1) {
      if (this.abOt == null) {
        break label392;
      }
    }
    label392:
    for (paramInt = i.a.a.b.b.a.h(1, this.abOt) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.abOu != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.abOu);
      }
      paramInt = i.a.a.a.c(3, 8, this.abOv);
      AppMethodBeat.o(153009);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.abOv.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(153009);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        fof localfof = (fof)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(153009);
          return -1;
        case 1: 
          localfof.abOt = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(153009);
          return 0;
        case 2: 
          localfof.abOu = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(153009);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          ass localass = new ass();
          if ((localObject != null) && (localObject.length > 0)) {
            localass.parseFrom((byte[])localObject);
          }
          localfof.abOv.add(localass);
          paramInt += 1;
        }
        AppMethodBeat.o(153009);
        return 0;
      }
      AppMethodBeat.o(153009);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fof
 * JD-Core Version:    0.7.0.1
 */