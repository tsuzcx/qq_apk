package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ff
  extends dyl
{
  public int RJZ;
  public int RKa;
  public int RKb;
  public long RKc;
  public int offset;
  public int scene;
  public String session_id;
  public int tpK;
  public String url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(103189);
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
      paramVarArgs.aY(4, this.offset);
      paramVarArgs.aY(6, this.tpK);
      paramVarArgs.aY(7, this.scene);
      paramVarArgs.aY(8, this.RJZ);
      paramVarArgs.aY(9, this.RKa);
      paramVarArgs.aY(10, this.RKb);
      if (this.session_id != null) {
        paramVarArgs.f(11, this.session_id);
      }
      paramVarArgs.bm(12, this.RKc);
      AppMethodBeat.o(103189);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label728;
      }
    }
    label728:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.url != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.url);
      }
      i = i + g.a.a.b.b.a.bM(4, this.offset) + g.a.a.b.b.a.bM(6, this.tpK) + g.a.a.b.b.a.bM(7, this.scene) + g.a.a.b.b.a.bM(8, this.RJZ) + g.a.a.b.b.a.bM(9, this.RKa) + g.a.a.b.b.a.bM(10, this.RKb);
      paramInt = i;
      if (this.session_id != null) {
        paramInt = i + g.a.a.b.b.a.g(11, this.session_id);
      }
      i = g.a.a.b.b.a.p(12, this.RKc);
      AppMethodBeat.o(103189);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(103189);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        ff localff = (ff)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        case 3: 
        case 5: 
        default: 
          AppMethodBeat.o(103189);
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
            localff.BaseRequest = localjg;
            paramInt += 1;
          }
          AppMethodBeat.o(103189);
          return 0;
        case 2: 
          localff.url = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(103189);
          return 0;
        case 4: 
          localff.offset = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(103189);
          return 0;
        case 6: 
          localff.tpK = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(103189);
          return 0;
        case 7: 
          localff.scene = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(103189);
          return 0;
        case 8: 
          localff.RJZ = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(103189);
          return 0;
        case 9: 
          localff.RKa = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(103189);
          return 0;
        case 10: 
          localff.RKb = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(103189);
          return 0;
        case 11: 
          localff.session_id = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(103189);
          return 0;
        }
        localff.RKc = ((g.a.a.a.a)localObject).abFh.AN();
        AppMethodBeat.o(103189);
        return 0;
      }
      AppMethodBeat.o(103189);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ff
 * JD-Core Version:    0.7.0.1
 */