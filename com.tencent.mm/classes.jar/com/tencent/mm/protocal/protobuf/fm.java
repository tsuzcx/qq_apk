package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class fm
  extends dyl
{
  public int RJZ;
  public int RKB;
  public int RKD;
  public long RKE;
  public int RKa;
  public int RKb;
  public long RKc;
  public String content;
  public int scene;
  public String session_id;
  public String title;
  public int tpK;
  public String url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(103199);
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
      if (this.content != null) {
        paramVarArgs.f(4, this.content);
      }
      paramVarArgs.bm(5, this.RKE);
      paramVarArgs.aY(6, this.tpK);
      paramVarArgs.aY(7, this.RKB);
      if (this.title != null) {
        paramVarArgs.f(8, this.title);
      }
      paramVarArgs.aY(9, this.scene);
      paramVarArgs.aY(10, this.RJZ);
      paramVarArgs.aY(11, this.RKa);
      paramVarArgs.aY(12, this.RKb);
      if (this.session_id != null) {
        paramVarArgs.f(13, this.session_id);
      }
      paramVarArgs.bm(14, this.RKc);
      paramVarArgs.aY(15, this.RKD);
      AppMethodBeat.o(103199);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label940;
      }
    }
    label940:
    for (int i = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.url != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.url);
      }
      i = paramInt;
      if (this.content != null) {
        i = paramInt + g.a.a.b.b.a.g(4, this.content);
      }
      i = i + g.a.a.b.b.a.p(5, this.RKE) + g.a.a.b.b.a.bM(6, this.tpK) + g.a.a.b.b.a.bM(7, this.RKB);
      paramInt = i;
      if (this.title != null) {
        paramInt = i + g.a.a.b.b.a.g(8, this.title);
      }
      i = paramInt + g.a.a.b.b.a.bM(9, this.scene) + g.a.a.b.b.a.bM(10, this.RJZ) + g.a.a.b.b.a.bM(11, this.RKa) + g.a.a.b.b.a.bM(12, this.RKb);
      paramInt = i;
      if (this.session_id != null) {
        paramInt = i + g.a.a.b.b.a.g(13, this.session_id);
      }
      i = g.a.a.b.b.a.p(14, this.RKc);
      int j = g.a.a.b.b.a.bM(15, this.RKD);
      AppMethodBeat.o(103199);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(103199);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        fm localfm = (fm)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        case 3: 
        default: 
          AppMethodBeat.o(103199);
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
            localfm.BaseRequest = localjg;
            paramInt += 1;
          }
          AppMethodBeat.o(103199);
          return 0;
        case 2: 
          localfm.url = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(103199);
          return 0;
        case 4: 
          localfm.content = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(103199);
          return 0;
        case 5: 
          localfm.RKE = ((g.a.a.a.a)localObject).abFh.AN();
          AppMethodBeat.o(103199);
          return 0;
        case 6: 
          localfm.tpK = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(103199);
          return 0;
        case 7: 
          localfm.RKB = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(103199);
          return 0;
        case 8: 
          localfm.title = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(103199);
          return 0;
        case 9: 
          localfm.scene = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(103199);
          return 0;
        case 10: 
          localfm.RJZ = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(103199);
          return 0;
        case 11: 
          localfm.RKa = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(103199);
          return 0;
        case 12: 
          localfm.RKb = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(103199);
          return 0;
        case 13: 
          localfm.session_id = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(103199);
          return 0;
        case 14: 
          localfm.RKc = ((g.a.a.a.a)localObject).abFh.AN();
          AppMethodBeat.o(103199);
          return 0;
        }
        localfm.RKD = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(103199);
        return 0;
      }
      AppMethodBeat.o(103199);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fm
 * JD-Core Version:    0.7.0.1
 */