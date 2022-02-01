package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ge
  extends erp
{
  public int YHV;
  public int YHW;
  public int YHX;
  public int YHt;
  public int YHu;
  public int YHv;
  public String openid;
  public int scene;
  public String session_id;
  public String url;
  public int wuj;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(177339);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.url != null) {
        paramVarArgs.g(2, this.url);
      }
      paramVarArgs.bS(5, this.YHV);
      if (this.openid != null) {
        paramVarArgs.g(6, this.openid);
      }
      paramVarArgs.bS(7, this.YHW);
      paramVarArgs.bS(8, this.wuj);
      paramVarArgs.bS(9, this.YHX);
      paramVarArgs.bS(10, this.scene);
      paramVarArgs.bS(11, this.YHt);
      paramVarArgs.bS(12, this.YHu);
      paramVarArgs.bS(13, this.YHv);
      if (this.session_id != null) {
        paramVarArgs.g(14, this.session_id);
      }
      AppMethodBeat.o(177339);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label832;
      }
    }
    label832:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.url != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.url);
      }
      i += i.a.a.b.b.a.cJ(5, this.YHV);
      paramInt = i;
      if (this.openid != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.openid);
      }
      i = paramInt + i.a.a.b.b.a.cJ(7, this.YHW) + i.a.a.b.b.a.cJ(8, this.wuj) + i.a.a.b.b.a.cJ(9, this.YHX) + i.a.a.b.b.a.cJ(10, this.scene) + i.a.a.b.b.a.cJ(11, this.YHt) + i.a.a.b.b.a.cJ(12, this.YHu) + i.a.a.b.b.a.cJ(13, this.YHv);
      paramInt = i;
      if (this.session_id != null) {
        paramInt = i + i.a.a.b.b.a.h(14, this.session_id);
      }
      AppMethodBeat.o(177339);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(177339);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        ge localge = (ge)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        case 3: 
        case 4: 
        default: 
          AppMethodBeat.o(177339);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            kc localkc = new kc();
            if ((localObject != null) && (localObject.length > 0)) {
              localkc.parseFrom((byte[])localObject);
            }
            localge.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(177339);
          return 0;
        case 2: 
          localge.url = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(177339);
          return 0;
        case 5: 
          localge.YHV = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(177339);
          return 0;
        case 6: 
          localge.openid = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(177339);
          return 0;
        case 7: 
          localge.YHW = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(177339);
          return 0;
        case 8: 
          localge.wuj = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(177339);
          return 0;
        case 9: 
          localge.YHX = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(177339);
          return 0;
        case 10: 
          localge.scene = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(177339);
          return 0;
        case 11: 
          localge.YHt = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(177339);
          return 0;
        case 12: 
          localge.YHu = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(177339);
          return 0;
        case 13: 
          localge.YHv = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(177339);
          return 0;
        }
        localge.session_id = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(177339);
        return 0;
      }
      AppMethodBeat.o(177339);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ge
 * JD-Core Version:    0.7.0.1
 */