package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;
import org.json.JSONObject;

public final class fah
  extends erp
{
  public String Njp;
  public gol YJj;
  public int aajL;
  public String ytj;
  
  private JSONObject toJSON()
  {
    AppMethodBeat.i(259728);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      com.tencent.mm.bk.a.a(localJSONObject, "BaseRequest", this.BaseRequest, false);
      com.tencent.mm.bk.a.a(localJSONObject, "Password", this.ytj, false);
      com.tencent.mm.bk.a.a(localJSONObject, "Ticket", this.Njp, false);
      com.tencent.mm.bk.a.a(localJSONObject, "AutoAuthKey", this.YJj, false);
      com.tencent.mm.bk.a.a(localJSONObject, "TicketType", Integer.valueOf(this.aajL), false);
      label71:
      AppMethodBeat.o(259728);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      break label71;
    }
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(134257);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.ytj != null) {
        paramVarArgs.g(2, this.ytj);
      }
      if (this.Njp != null) {
        paramVarArgs.g(3, this.Njp);
      }
      if (this.YJj != null)
      {
        paramVarArgs.qD(4, this.YJj.computeSize());
        this.YJj.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(5, this.aajL);
      AppMethodBeat.o(134257);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label582;
      }
    }
    label582:
    for (int i = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.ytj != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.ytj);
      }
      i = paramInt;
      if (this.Njp != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.Njp);
      }
      paramInt = i;
      if (this.YJj != null) {
        paramInt = i + i.a.a.a.qC(4, this.YJj.computeSize());
      }
      i = i.a.a.b.b.a.cJ(5, this.aajL);
      AppMethodBeat.o(134257);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(134257);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        fah localfah = (fah)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(134257);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new kc();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((kc)localObject2).parseFrom((byte[])localObject1);
            }
            localfah.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(134257);
          return 0;
        case 2: 
          localfah.ytj = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(134257);
          return 0;
        case 3: 
          localfah.Njp = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(134257);
          return 0;
        case 4: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new gol();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((gol)localObject2).dg((byte[])localObject1);
            }
            localfah.YJj = ((gol)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(134257);
          return 0;
        }
        localfah.aajL = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(134257);
        return 0;
      }
      AppMethodBeat.o(134257);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fah
 * JD-Core Version:    0.7.0.1
 */