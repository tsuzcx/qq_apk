package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class fz
  extends erp
{
  public int YHt;
  public int YHu;
  public int YHv;
  public long YHw;
  public int offset;
  public int scene;
  public String session_id;
  public String url;
  public int wuj;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(103189);
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
      paramVarArgs.bS(4, this.offset);
      paramVarArgs.bS(6, this.wuj);
      paramVarArgs.bS(7, this.scene);
      paramVarArgs.bS(8, this.YHt);
      paramVarArgs.bS(9, this.YHu);
      paramVarArgs.bS(10, this.YHv);
      if (this.session_id != null) {
        paramVarArgs.g(11, this.session_id);
      }
      paramVarArgs.bv(12, this.YHw);
      AppMethodBeat.o(103189);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label724;
      }
    }
    label724:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.url != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.url);
      }
      i = i + i.a.a.b.b.a.cJ(4, this.offset) + i.a.a.b.b.a.cJ(6, this.wuj) + i.a.a.b.b.a.cJ(7, this.scene) + i.a.a.b.b.a.cJ(8, this.YHt) + i.a.a.b.b.a.cJ(9, this.YHu) + i.a.a.b.b.a.cJ(10, this.YHv);
      paramInt = i;
      if (this.session_id != null) {
        paramInt = i + i.a.a.b.b.a.h(11, this.session_id);
      }
      i = i.a.a.b.b.a.q(12, this.YHw);
      AppMethodBeat.o(103189);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(103189);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        fz localfz = (fz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        case 3: 
        case 5: 
        default: 
          AppMethodBeat.o(103189);
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
            localfz.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(103189);
          return 0;
        case 2: 
          localfz.url = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(103189);
          return 0;
        case 4: 
          localfz.offset = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(103189);
          return 0;
        case 6: 
          localfz.wuj = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(103189);
          return 0;
        case 7: 
          localfz.scene = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(103189);
          return 0;
        case 8: 
          localfz.YHt = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(103189);
          return 0;
        case 9: 
          localfz.YHu = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(103189);
          return 0;
        case 10: 
          localfz.YHv = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(103189);
          return 0;
        case 11: 
          localfz.session_id = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(103189);
          return 0;
        }
        localfz.YHw = ((i.a.a.a.a)localObject).ajGk.aaw();
        AppMethodBeat.o(103189);
        return 0;
      }
      AppMethodBeat.o(103189);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fz
 * JD-Core Version:    0.7.0.1
 */