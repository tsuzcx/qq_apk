package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;
import org.json.JSONObject;

public final class fdb
  extends esc
{
  public String aayf;
  public int abCC;
  public int abCD;
  public int abCE;
  public b abCF;
  public String abCq;
  public String abCr;
  public String abCs;
  
  private JSONObject toJSON()
  {
    AppMethodBeat.i(258856);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      com.tencent.mm.bk.a.a(localJSONObject, "BaseResponse", this.BaseResponse, false);
      com.tencent.mm.bk.a.a(localJSONObject, "PickedWord", this.abCq, false);
      com.tencent.mm.bk.a.a(localJSONObject, "PrefixOffset", Integer.valueOf(this.abCC), false);
      com.tencent.mm.bk.a.a(localJSONObject, "SuffixOffset", Integer.valueOf(this.abCD), false);
      com.tencent.mm.bk.a.a(localJSONObject, "PrefixText", this.abCr, false);
      com.tencent.mm.bk.a.a(localJSONObject, "SuffixText", this.abCs, false);
      com.tencent.mm.bk.a.a(localJSONObject, "PickedType", Integer.valueOf(this.abCE), false);
      com.tencent.mm.bk.a.a(localJSONObject, "SearchId", this.aayf, false);
      com.tencent.mm.bk.a.a(localJSONObject, "ExtQueryInfo", this.abCF, false);
      label121:
      AppMethodBeat.o(258856);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      break label121;
    }
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117928);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.abCq != null) {
        paramVarArgs.g(2, this.abCq);
      }
      paramVarArgs.bS(3, this.abCC);
      paramVarArgs.bS(4, this.abCD);
      if (this.abCr != null) {
        paramVarArgs.g(5, this.abCr);
      }
      if (this.abCs != null) {
        paramVarArgs.g(6, this.abCs);
      }
      paramVarArgs.bS(7, this.abCE);
      if (this.aayf != null) {
        paramVarArgs.g(8, this.aayf);
      }
      if (this.abCF != null) {
        paramVarArgs.d(9, this.abCF);
      }
      AppMethodBeat.o(117928);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label724;
      }
    }
    label724:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.abCq != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.abCq);
      }
      i = i + i.a.a.b.b.a.cJ(3, this.abCC) + i.a.a.b.b.a.cJ(4, this.abCD);
      paramInt = i;
      if (this.abCr != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.abCr);
      }
      i = paramInt;
      if (this.abCs != null) {
        i = paramInt + i.a.a.b.b.a.h(6, this.abCs);
      }
      i += i.a.a.b.b.a.cJ(7, this.abCE);
      paramInt = i;
      if (this.aayf != null) {
        paramInt = i + i.a.a.b.b.a.h(8, this.aayf);
      }
      i = paramInt;
      if (this.abCF != null) {
        i = paramInt + i.a.a.b.b.a.c(9, this.abCF);
      }
      AppMethodBeat.o(117928);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(117928);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        fdb localfdb = (fdb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(117928);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            kd localkd = new kd();
            if ((localObject != null) && (localObject.length > 0)) {
              localkd.parseFrom((byte[])localObject);
            }
            localfdb.BaseResponse = localkd;
            paramInt += 1;
          }
          AppMethodBeat.o(117928);
          return 0;
        case 2: 
          localfdb.abCq = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(117928);
          return 0;
        case 3: 
          localfdb.abCC = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(117928);
          return 0;
        case 4: 
          localfdb.abCD = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(117928);
          return 0;
        case 5: 
          localfdb.abCr = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(117928);
          return 0;
        case 6: 
          localfdb.abCs = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(117928);
          return 0;
        case 7: 
          localfdb.abCE = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(117928);
          return 0;
        case 8: 
          localfdb.aayf = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(117928);
          return 0;
        }
        localfdb.abCF = ((i.a.a.a.a)localObject).ajGk.kFX();
        AppMethodBeat.o(117928);
        return 0;
      }
      AppMethodBeat.o(117928);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fdb
 * JD-Core Version:    0.7.0.1
 */