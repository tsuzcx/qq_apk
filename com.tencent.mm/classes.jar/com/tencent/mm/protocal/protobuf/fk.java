package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class fk
  extends dyl
{
  public int RJZ;
  public int RKB;
  public int RKC;
  public int RKD;
  public int RKa;
  public int RKb;
  public String openid;
  public int scene;
  public String session_id;
  public int tpK;
  public String url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(177339);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.url != null) {
        paramVarArgs.f(2, this.url);
      }
      paramVarArgs.aY(5, this.RKB);
      if (this.openid != null) {
        paramVarArgs.f(6, this.openid);
      }
      paramVarArgs.aY(7, this.RKC);
      paramVarArgs.aY(8, this.tpK);
      paramVarArgs.aY(9, this.RKD);
      paramVarArgs.aY(10, this.scene);
      paramVarArgs.aY(11, this.RJZ);
      paramVarArgs.aY(12, this.RKa);
      paramVarArgs.aY(13, this.RKb);
      if (this.session_id != null) {
        paramVarArgs.f(14, this.session_id);
      }
      AppMethodBeat.o(177339);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label836;
      }
    }
    label836:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.url != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.url);
      }
      i += g.a.a.b.b.a.bM(5, this.RKB);
      paramInt = i;
      if (this.openid != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.openid);
      }
      i = paramInt + g.a.a.b.b.a.bM(7, this.RKC) + g.a.a.b.b.a.bM(8, this.tpK) + g.a.a.b.b.a.bM(9, this.RKD) + g.a.a.b.b.a.bM(10, this.scene) + g.a.a.b.b.a.bM(11, this.RJZ) + g.a.a.b.b.a.bM(12, this.RKa) + g.a.a.b.b.a.bM(13, this.RKb);
      paramInt = i;
      if (this.session_id != null) {
        paramInt = i + g.a.a.b.b.a.g(14, this.session_id);
      }
      AppMethodBeat.o(177339);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(177339);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        fk localfk = (fk)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        case 3: 
        case 4: 
        default: 
          AppMethodBeat.o(177339);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            jg localjg = new jg();
            if ((localObject != null) && (localObject.length > 0)) {
              localjg.parseFrom((byte[])localObject);
            }
            localfk.BaseRequest = localjg;
            paramInt += 1;
          }
          AppMethodBeat.o(177339);
          return 0;
        case 2: 
          localfk.url = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(177339);
          return 0;
        case 5: 
          localfk.RKB = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(177339);
          return 0;
        case 6: 
          localfk.openid = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(177339);
          return 0;
        case 7: 
          localfk.RKC = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(177339);
          return 0;
        case 8: 
          localfk.tpK = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(177339);
          return 0;
        case 9: 
          localfk.RKD = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(177339);
          return 0;
        case 10: 
          localfk.scene = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(177339);
          return 0;
        case 11: 
          localfk.RJZ = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(177339);
          return 0;
        case 12: 
          localfk.RKa = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(177339);
          return 0;
        case 13: 
          localfk.RKb = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(177339);
          return 0;
        }
        localfk.session_id = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(177339);
        return 0;
      }
      AppMethodBeat.o(177339);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fk
 * JD-Core Version:    0.7.0.1
 */